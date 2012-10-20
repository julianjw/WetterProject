package com.wetterproject.wettersearch;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

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
		String jsonFile = "http://search.twitter.com/search.json?q=" + query + "%20filter:links" + "&lang=en&include_entities=true&result_type=mixed";
	    
		//Read the json from the url and store it into a json object
		JSONObject json = new JSONObject();
		
		try {
			json = readJsonFromUrl(jsonFile);
			System.out.println(json.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<TwitterResults> results = new ArrayList<TwitterResults>();
		
		try {
			JSONObject jso = new JSONObject(json.toString());
			JSONArray ja = jso.getJSONArray("results");

			for (int i = 0; i < ja.length(); i++) {
			    TwitterResults newResult = new TwitterResults();
			    JSONObject jsonSection = ja.getJSONObject(i);

			    newResult.setText(jsonSection.getString("text"));
			    newResult.setUserName(jsonSection.getString("from_user_name"));
			    newResult.setCreatedAt(jsonSection.getString("created_at"));
			    newResult.setGeo(jsonSection.getString("geo"));
			    newResult.setTo_user_name(jsonSection.getString("to_user_name"));
			    newResult.setSource(jsonSection.getString("source"));
			    
			    JSONObject jsonSectionEntity = jsonSection.getJSONObject("entities");
			    JSONObject jsonSectionMetadata = jsonSection.getJSONObject("metadata");
			    
			    JSONArray jaEntityUrls = jsonSectionEntity.getJSONArray("urls");
			    
			    try {
			    	JSONObject jsonSectionEntityUrls = jaEntityUrls.getJSONObject(0);
			    	newResult.setUrl(jsonSectionEntityUrls.getString("url"));
			    } catch (Exception e) {}
			    
			    newResult.setResult_type(jsonSectionMetadata.getString("result_type"));
			    
			    try {
			    	newResult.setRetweets(jsonSectionMetadata.getInt("recent_retweets"));
			    } catch (Exception e) {}
			    
			   //add it to the results database
			   results.add(newResult);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Display some results (for testing only)
		for (int j=0; j<results.size(); j++) {
			System.out.println(results.get(j).GetText());
			System.out.println(results.get(j).GetUserName());
			System.out.println(results.get(j).GetCreatedAt());
		}
		
		//Sort results into most relevant (the links that are most referred to)
		
		
		//Display results
		
		
		
    }
}
