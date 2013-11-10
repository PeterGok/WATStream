package com.pianist.watstream;

import java.util.TimerTask;

import org.json.JSONException;

public class UpdateTimer extends TimerTask {
	  
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
		}
	  }
}
