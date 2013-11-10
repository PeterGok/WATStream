package com.pianist.watstream;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ViewPageAdapter extends FragmentPagerAdapter
{	
	public ViewPageAdapter (FragmentManager fm)   {
        super(fm);
    }

	@Override
	public Fragment getItem(int arg0)
	{
		return PageFragment.newInstance(arg0);
	}

	@Override
	public int getCount()
	{
		return 5;
	}
}
