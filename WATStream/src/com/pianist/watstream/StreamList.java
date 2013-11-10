package com.pianist.watstream;

import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class StreamList extends LinearLayout
{
	Context context;
	ViewGroup layout;
	ArrayList<Event> streams;

	public StreamList(Context context)
	{
		super(context);
		this.context = context;
		this.setOrientation(VERTICAL);
		streams = new ArrayList<Event>();
		layout = (ViewGroup) this;
	}
	
	public void addBox (String title, Date date, String mainText)
	{
		final float scale = getContext().getResources().getDisplayMetrics().density;
		Event tv = new Event (context, title, date, mainText);
		tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(150 * scale)));
		streams.add(tv);
		layout.addView(tv);
	}
}
