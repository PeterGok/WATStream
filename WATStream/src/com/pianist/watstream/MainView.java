package com.pianist.watstream;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainView extends LinearLayout
{
	ViewGroup layout;
	ScrollContainer scroll;
	MenuBar menu;

	public MainView(Context context)
	{
		super(context);
		layout = (ViewGroup) this;
		this.setOrientation(VERTICAL);
		final float scale = getContext().getResources().getDisplayMetrics().density;
		menu = new MenuBar(context);
		layout.addView(menu);
		scroll = new ScrollContainer(context);
		layout.addView(scroll);
	}

}
