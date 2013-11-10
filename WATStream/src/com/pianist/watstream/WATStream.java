package com.pianist.watstream;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WATStream extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		MainView view = new MainView (this);
		setContentView(view);
		
		view.stream.addBox("Hello");
		view.stream.addBox("Bryan Feeds");
		view.stream.addBox("Bryan Feeds");
		view.stream.addBox("Bryan Feeds");
		view.stream.addBox("Bryan Feeds");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.watstream, menu);
		return true;
	}

}
