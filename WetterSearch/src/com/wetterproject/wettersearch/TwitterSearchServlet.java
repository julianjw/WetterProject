package com.wetterproject.wettersearch;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.*;

@SuppressWarnings("serial")
public class TwitterSearchServlet extends HttpServlet {
	
	Gson gson = new Gson();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		
	}
	
	//Roland Illig (Stack Overflow)
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	    	sb.append((char) cp);
	    }
	    return sb.toString();
  	}
  
	//Roland Illig (Stack Overflow)
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	    	BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      	String jsonText = readAll(rd);
	      	JSONObject json = new JSONObject(jsonText);
	      	return json;
	    } finally {
	    	is.close();
	    }
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	
		resp.setContentType("text/plain");
		
		String query = req.getParameter("query");
		
		//Create url from the query given
		String jsonFile = "http://search.twitter.com/search.json?q=" + query + "%20filter:links" + "&result_type=mixed";
	    
		//Read the json from the url and store it into a json object
		JSONObject json = new JSONObject();
		
		try {
			json = readJsonFromUrl(jsonFile);
			System.out.println(json.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<TwitterResults> results = new ArrayList<TwitterResults>();
		
		//Store all the results into a database of some sort
/*		for (int i=0; i<json.length(); i++) {
			results[i].userName = json.get("user_name");
			
		}*/
		
		JSONArray resultsJson = null;
		
		try {
			resultsJson = json.getJSONArray("results");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			for (int i=0; i<resultsJson.length(); i++) {
				TwitterResults newResult = new TwitterResults();
				
				//JSONObject newJson = (JSONObject) json.get("from_user_name");
				
				newResult.userName = json.getString("from_user_name");
				newResult.text = json.getString("text");
				
				System.out.println(newResult.text);
				System.out.println(newResult.userName);
				
				results.add(newResult);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Sort results into most relevant (the links that are most referred to)
		
		
		//Display results
		
		
		
    }
}
