package com.wetterproject.wettersearch;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.search.Results;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

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
		String jsonFile = "http://search.twitter.com/search.json?q=" + query + "%20filter:links" + "&include_entities=true&result_type=mixed";
	    
		//Read the json from the url and store it into a json object
		JSONObject json = new JSONObject();
		
		try {
			json = readJsonFromUrl(jsonFile);
			System.out.println(json.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//List<TwitterResults> results = new ArrayList<TwitterResults>();
		
		//Store all the results into a database of some sort
/*		for (int i=0; i<json.length(); i++) {
			results[i].userName = json.get("user_name");
			
		}*/
		
		JSONArray resultsJson = null;
		JSONObject resultsJsonObj = new JSONObject();
		
		//TwitterResults[] results = null;
		
		//TwitterResults[] results = null;
		
		//ArrayList<TwitterResults> results = new ArrayList<TwitterResults>();
		
		//String[] text = null;
		
		try {
			resultsJson = json.getJSONArray("results");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrayList<TwitterResults> results = new ArrayList<TwitterResults>();
		
		try {
			resultsJsonObj = resultsJson.toJSONObject(resultsJson);
			
/*		    Gson gson = new Gson();
		    JsonParser parser = new JsonParser();
		    JsonArray Jarray = parser.parse(JSONObject.getNames(resultsJsonObj).toString()).getAsJsonArray();

		    //ArrayList<TwitterResults> results = new ArrayList<TwitterResults>();

		    for(JsonElement obj : Jarray )
		    {
		        TwitterResults newResult = gson.fromJson( obj , TwitterResults.class);
		        results.add(newResult);
		    }*/
			
/*			for (int i=0; i<resultsJsonObj.length(); i++) {
				String jsonString = JSONObject.getNames(resultsJsonObj)[0].toString();
				
				//System.out.println(JSONObject.getNames(resultsJsonObj)[i].toString());
				results = new Gson().fromJson(jsonString, TwitterResults[].class);
			}*/
			
			JSONObject jso = new JSONObject(json.toString());
			JSONArray ja = jso.getJSONArray("results");

			for (int i = 0; i < ja.length(); i++) {
			    TwitterResults newResult = new TwitterResults();
			    JSONObject jsonSection = ja.getJSONObject(i);

			    newResult.setText(jsonSection.getString("text"));
			    newResult.setUserName(jsonSection.getString("from_user_name"));
			    //s.SectionName = jsonSection.getString("SectionName");

			   //add it to sections list
			   results.add(newResult);
			}
			
			//results = new Gson().fromJson(resultsJson.toString(i), TwitterResults[].class);
			//results = new Gson().fromJson(resultsJsonObj.toString(), TwitterResults[].class);
			
/*			for (int i=0; i<resultsJson.length(); i++) {
			//while (resultsJsonObj.keys().hasNext()) {
				TwitterResults newResult = new Gson().fromJson(resultsJsonObj.toString(), TwitterResults.class);
				
				//JSONObject newJson = (JSONObject) json.get("from_user_name");
				
				//System.out.println(resultsJson.getString(i));
				
				Data data = new Gson().fromJson(json, Data.class);
				
				text = JSONObject.getNames(resultsJsonObj);
				
				
				
				JSONObject newJson = new JSONObject();
				newJson.put((String)resultsJsonObj.names().get(i), i);
				
				System.out.println(newJson.getString("text"));
				
				//System.out.println(resultsJsonObj.getString("text"));
				
				//System.out.println(resultsJsonObj.)
				
				//newResult.userName = json.getString("from_user_name");
				//newResult.text = json.getString("text");
				
				//System.out.println(newResult.text);
				//System.out.println(newResult.userName);
				
				results.add(newResult);
			}*/
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (int j=0; j<results.size(); j++) {
			System.out.println(results.get(j).GetText());
			System.out.println(results.get(j).GetUserName());
			System.out.println(results.get(j).GetCreatedAt());
		}
		
/*		for (int j=0; j<results.length; j++) {
			System.out.println(results[j].GetText());
			System.out.println(results[j].GetUserName());
			System.out.println(results[j].GetCreatedAt());
		}*/
		
		
		//Sort results into most relevant (the links that are most referred to)
		
		
		//Display results
		
		
		
    }
}
