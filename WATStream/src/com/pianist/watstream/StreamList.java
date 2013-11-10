package com.pianist.watstream;

import java.util.ArrayList;

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
	ArrayList<Stream> streams;

	public StreamList(Context context)
	{
		super(context);
		this.context = context;
		this.setOrientation(VERTICAL);
		streams = new ArrayList<Stream>();
		layout = (ViewGroup) this;
	}
	
	public void addBox (String text)
	{
		Stream tv = new Stream (context);
		tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 200));
		tv.setText(text);
		streams.add(tv);
		layout.addView(tv);
	}
}
