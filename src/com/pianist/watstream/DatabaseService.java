package com.pianist.watstream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.content.Context;
import android.util.Log;

public class DatabaseService {
	  private static DatabaseService _instance = new DatabaseService();
	  public static Context context;
	  public static WATStream reference;

	  public static ArrayList <Event> events = new ArrayList <Event> ();

	  public static DatabaseService getInstance() {
	    return _instance;
	  }

	  private void updateEvents(JSONObject jObject, ArrayList<Event> newEvents) throws JSONException {
	    
	    for (int i=0; i < jObject.length() / 3; i++){
	      String title = jObject.getString("title");
	      String date = jObject.getString("date");
	      String mainText = jObject.getString("maintext");
	      newEvents.add(new Event (context, title, date, mainText));
	    }
	    
	  }

	  public void connect() throws JSONException {
	    
	    DefaultHttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://watstream.co.nf/getInfo.php");

	    InputStream inputStream = null;
	    
	    String result = null;
	    try {
	        HttpResponse response = httpclient.execute(httppost);
	        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	        HttpEntity entity = response.getEntity();

	        inputStream = entity.getContent();
	        // json is UTF-8 by default
	        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
	        StringBuilder sb = new StringBuilder();

	        String line = null;
	        while ((line = reader.readLine()) != null)
	        {
	            sb.append(line + "\n");
	        }
	        result = sb.toString();
	    } catch (Exception e) { 
	        Log.v("ioexception", e.toString());
	    }
	    
	    ArrayList<Event> newEvents = new ArrayList <Event> ();
	    
	    result = result.substring(0, result.length()-2);
	    
	    for (String object : result.split("\\}"))
	    {
	    	JSONObject jObject = new JSONObject("{" + object.substring(2) + "}");
	    	updateEvents (jObject, newEvents);
	    }
	    
	    events = newEvents;
	  }

	  /**public void setPosition( int game, int x, int y, int color ) {
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost("http://10.0.2.2/ttt/move.php");

	    positions[x][y] = color;

	    try {
	      List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	      nameValuePairs.add(new BasicNameValuePair("game", Integer.toString(game)));
	      nameValuePairs.add(new BasicNameValuePair("x", Integer.toString(x)));
	      nameValuePairs.add(new BasicNameValuePair("y", Integer.toString(y)));
	      nameValuePairs.add(new BasicNameValuePair("color", Integer.toString(color)));
	      httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	      HttpResponse response = httpclient.execute(httppost);
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      DocumentBuilder db = dbf.newDocumentBuilder();
	      updatePositions( db.parse(response.getEntity().getContent()) );
	    } catch (Exception e) {
	      Log.v("ioexception", e.toString());
	    }
	  }*/
	}
