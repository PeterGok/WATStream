package com.pianist.watstream;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ScrollView;

public class ScrollContainer extends ScrollView implements Runnable
{
	StreamList stream;
	ViewGroup layout;

	public ScrollContainer(Context context)
	{
		super(context);
		this.setVerticalScrollBarEnabled(false);
		stream = new StreamList(context);
		layout = (ViewGroup)this;
		layout.addView(stream);
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}
}
