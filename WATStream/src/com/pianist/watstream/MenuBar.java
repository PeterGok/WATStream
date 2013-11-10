package com.pianist.watstream;

import java.util.ArrayList;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;

public class MenuBar extends HorizontalScrollView
{
	Button [] options;
	ViewGroup layout;
	

	public MenuBar(Context context)
	{
		super(context);
		this.setHorizontalScrollBarEnabled(false);
		layout = (ViewGroup)this;
		layout.addView(new MenuList (context));
	}
	
}
