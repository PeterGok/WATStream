package com.pianist.watstream;

import java.util.TimerTask;

import org.json.JSONException;

import android.util.Log;

public class UpdateTimer extends TimerTask {
	
	WATStream reference;
	
	public UpdateTimer (WATStream reference)
	{
		this.reference = reference;
	}
	  
	  @Override
	  public void run() {
	    try
		{
			DatabaseService.getInstance().connect();
			
		}
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.v("ioexception", e.toString());
		}
	  }
}
