package com.pianist.watstream;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.FrameLayout.LayoutParams;

public class MenuList extends LinearLayout
{
	MenuButton [] buttons;
	ViewGroup layout;

	public MenuList(Context context)
	{
		super(context);
		layout = (ViewGroup)this;
		
		this.setOrientation(HORIZONTAL);

		buttons = new MenuButton [5];
		
		final float scale = getContext().getResources().getDisplayMetrics().density;
		
		buttons [0] = new MenuButton (context);
		buttons[0].setText("Main");

		buttons [1] = new MenuButton (context);
		buttons[1].setText("Food");

		buttons [2] = new MenuButton (context);
		buttons[2].setText("Exams");
		
		buttons [3] = new MenuButton (context);
		buttons[3].setText("Other");
		
		buttons [4] = new MenuButton (context);
		buttons[4].setText("Bryan");
		
		layout = (ViewGroup)this;
		
		for (int option = 0; option < buttons.length; option++)
		{
			buttons[option].setTextColor(Color.BLACK);
			buttons[option].setLayoutParams(new LayoutParams((int)(buttons[option].getText().length() * 25 * scale), (int)(70 * scale)));
			buttons[option].setTextSize(20 * scale);
			buttons[option].setBackgroundColor(Color.TRANSPARENT);
			layout.addView(buttons[option]);
			
		}
		
	}

}
