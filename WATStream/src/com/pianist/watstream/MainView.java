package com.pianist.watstream;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainView extends ScrollView implements Runnable
{
	ViewGroup layout;
	Context context;
	StreamList stream;
	
	public MainView(Context context)
	{
		super(context);
		this.context = context;
		layout = (ViewGroup) this;
		stream = new StreamList(context);
		layout.addView(stream);
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}

}
