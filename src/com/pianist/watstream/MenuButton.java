package com.pianist.watstream;

import java.lang.reflect.Field;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.*;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.HorizontalScrollView;

public class MenuButton extends Button implements OnTouchListener
{
	WATStream reference;
	int number;
	
	public MenuButton(Context context, WATStream reference, int number)
	{
		super(context);
		this.reference = reference;
		this.setOnTouchListener(this);
		this.number = number;
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent e)
	{
		if (e.getActionMasked() == MotionEvent.ACTION_UP)
		{
			reference.horScroll.smoothScrollTo(reference.menuPos[number + 1] - reference.menuBar.getWidth() / 2 + reference.buttons[number].getWidth() / 2, 0);
			for (int button = 0; button < reference.buttons.length; button++)
				reference.buttons[button].setBackgroundColor(Color.TRANSPARENT);
			reference.buttons[number].setBackgroundColor(Color.LTGRAY);
			try {
	            Field mScroller;
	            mScroller = ViewPager.class.getDeclaredField("mScroller");
	            mScroller.setAccessible(true); 
	            FixedSpeedScroller scroller = new FixedSpeedScroller(reference.myViewPager.getContext());
	            mScroller.set(reference.myViewPager, scroller);
	        } catch (NoSuchFieldException f) {
	        } catch (IllegalArgumentException f) {
	        } catch (IllegalAccessException f) {
	        }
			reference.myViewPager.setCurrentItem(number);
		}
		return false;
	}
	
	public void moveScroller () 
	{
		reference.horScroll.smoothScrollTo(reference.menuPos[number + 1] - reference.menuBar.getWidth() / 2 + reference.buttons[number].getWidth() / 2, 0);
		for (int button = 0; button < reference.buttons.length; button++)
			reference.buttons[button].setBackgroundColor(Color.TRANSPARENT);
		reference.buttons[number].setBackgroundColor(Color.LTGRAY);
	}

}
