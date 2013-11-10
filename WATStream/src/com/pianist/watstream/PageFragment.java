package com.pianist.watstream;

import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PageFragment extends Fragment
{
	TextView tv;
	int num;

	public static PageFragment newInstance(int num)
	{
		PageFragment pageFragment = new PageFragment();
		
		Bundle bundle = new Bundle();
		bundle.putInt("num", num);
		pageFragment.setArguments(bundle);

		return pageFragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		num = getArguments() != null ? getArguments().getInt("num") : 1;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.mainstream, container, false);

		LinearLayout stream = (LinearLayout) v.findViewById(R.id.scroller);
		stream.setOrientation(LinearLayout.VERTICAL);

		if (num % 2 == 1)
		{
			addBox(stream,
				"Hello",
				new Date(1384056633),
				"ALESD Blah Blah BlahBlah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah");
			addBox(stream, "Bryan Feeds", new Date(1384026633), "Blah Blah");
			addBox(stream, "Bryan Feeds", new Date(1324056633), "Blah Blah");
			addBox(stream, "Bryan Feeds", new Date(1084056633), "Blah Blah");
			addBox(stream, "Bryan Feeds", new Date(384056633), "Blah Blah");
		}
		else
		{
			for (Event e : DatabaseService.events)
			{
				final float scale = stream.getContext().getResources().getDisplayMetrics().density;
				e.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(150 * scale)));
				stream.addView(e);
			}
		}

		return v;
	}
	
	public void addBox (LinearLayout layout, String title, Date date, String mainText)
	{
		final float scale = layout.getContext().getResources().getDisplayMetrics().density;
		Event tv = new Event (layout.getContext(), title, date.toString(), mainText);
		tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(150 * scale)));
		layout.addView(tv);
	}
}
