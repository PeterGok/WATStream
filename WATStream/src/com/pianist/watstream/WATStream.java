package com.pianist.watstream;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class WATStream extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		MainView view = new MainView (this);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(view);
		
		view.scroll.stream.addBox("Hello", new Date (1384056633), "ALESD Blah Blah BlahBlah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah Blah");
		view.scroll.stream.addBox("Bryan Feeds", new Date (1384026633), "Blah Blah");
		view.scroll.stream.addBox("Bryan Feeds", new Date (1324056633), "Blah Blah");
		view.scroll.stream.addBox("Bryan Feeds", new Date (1084056633), "Blah Blah");
		view.scroll.stream.addBox("Bryan Feeds", new Date (384056633), "Blah Blah");
	}

}
