package com.pianist.watstream;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.*;
import android.widget.Button;

public class MenuButton extends Button implements OnTouchListener
{
	public MenuButton(Context context)
	{
		super(context);
		this.setOnTouchListener(this);
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent e)
	{
		if (e.getActionMasked() == MotionEvent.ACTION_DOWN)
			this.setTextColor(Color.GRAY);
		else
			this.setTextColor(Color.BLACK);
		return false;
	}

}
