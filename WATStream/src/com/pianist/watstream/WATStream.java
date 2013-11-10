package com.pianist.watstream;

import java.util.Date;
import java.util.Timer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class WATStream extends FragmentActivity
{
	static int numberOfPages = 2;
	ViewPager myViewPager;
	ViewPageAdapter myFragmentPagerAdapter;
	    String text = "test";
	MenuButton [] buttons;
	HorizontalScrollView horScroll;
	LinearLayout menuBar;
	int [] menuPos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_watstream);
		
		menuBar = (LinearLayout) findViewById (R.id.menuBar);
		horScroll = (HorizontalScrollView) findViewById (R.id.horScroll);
		
		menuBar.setOrientation(LinearLayout.HORIZONTAL);
		
		DatabaseService.reference = this;

		buttons = new MenuButton [5];
		
		Timer timer = new Timer();
		UpdateTimer ut = new UpdateTimer(this);
	    timer.schedule( ut, 0, 1);
		
		Context context = menuBar.getContext();
		DatabaseService.context = context;
		
		final float scale = context.getResources().getDisplayMetrics().density;
		
		buttons [0] = new MenuButton (context, this, 0);
		buttons[0].setText("Main");

		buttons [1] = new MenuButton (context, this, 1);
		buttons[1].setText("Food");

		buttons [2] = new MenuButton (context, this, 2);
		buttons[2].setText("Exams");
		
		buttons [3] = new MenuButton (context, this, 3);
		buttons[3].setText("Other");
		
		buttons [4] = new MenuButton (context, this, 4);
		buttons[4].setText("Bryan");
		
		ViewGroup layout = (ViewGroup)menuBar;
		
		menuPos = new int [buttons.length + 1];
		menuPos[0] = 0;
		
		for (int option = 0; option < buttons.length; option++)
		{
			buttons[option].setTextColor(Color.BLACK);
			buttons[option].setLayoutParams(new LayoutParams((int)(buttons[option].getText().length() * 25 * scale), (int)(70 * scale)));
			menuPos[option + 1] = menuPos [option] +  (int)(buttons[option].getText().length() * 25 * scale);
			buttons[option].setTextSize(20 * scale);
			buttons[option].setBackgroundColor(Color.TRANSPARENT);
			layout.addView(buttons[option]);
			
		}
		
		menuBar.setHorizontalScrollBarEnabled(false);
		
		myViewPager = (ViewPager) findViewById(R.id.pager);
	    myFragmentPagerAdapter = new ViewPageAdapter (getSupportFragmentManager());
	    myViewPager.setAdapter(myFragmentPagerAdapter);
	    
	    myViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int page)
			{
				// TODO Auto-generated method stub
				buttons [page].moveScroller();
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int page)
			{
				
			}
		});
	}
	
	public void createFlip ()
	{
		myViewPager.setCurrentItem(myViewPager.getCurrentItem());
	}

}
