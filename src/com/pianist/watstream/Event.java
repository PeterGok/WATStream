package com.pianist.watstream;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class Event extends TextView
{
	String title;
	String date;
	String mainText;
	ViewGroup layout;
	Context context;
	
	public Event(Context context, String title, String date, String mainText)
	{
		super(context);
		this.title = title;
		this.mainText = mainText;
		this.context = context;
		this.date = date;
		//this.date = new SimpleDateFormat("MM-dd").format(date);
	}
	
	public void draw (Canvas g)
	{
		final float scale = getContext().getResources().getDisplayMetrics().density;
		Rect bounds = g.getClipBounds();
		Paint paint = new Paint ();
		paint.setColor(Color.DKGRAY);
		g.drawRect(5 * scale, 5 * scale, bounds.right - 5 * scale, bounds.bottom - 5 * scale, paint);
		paint.setColor(Color.YELLOW);
		paint.setTextSize(20 * scale);
		
		g.drawText(title, 15 * scale, 30 * scale, paint);
		paint.setTextSize(15 * scale);
		paint.setTypeface(Typeface.SERIF);
		
		TextView temp = new TextView (context);
		temp.setText(mainText);
		temp.setDrawingCacheEnabled(true);
		temp.setTextColor(Color.YELLOW);
		temp.measure(MeasureSpec.makeMeasureSpec((int)(bounds.right - 50 * scale), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec((int)(bounds.bottom - 70 * scale), MeasureSpec.EXACTLY));
		
		temp.layout(0, 0, temp.getMeasuredWidth(), temp.getMeasuredHeight());
		
		g.drawBitmap(temp.getDrawingCache(), 50, 80, paint);
		temp.setDrawingCacheEnabled(false);
		
		g.drawText(date.toString(), 15 * scale, 50 * scale, paint);
	}
}
