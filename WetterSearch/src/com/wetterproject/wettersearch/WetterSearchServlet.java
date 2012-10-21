package com.wetterproject.wettersearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@SuppressWarnings("serial")
public class WetterSearchServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		resp.setContentType("text/plain");
		
		String query = req.getParameter("q");
		String tempString = "";
		
		for (int z=0; z<query.length(); z++) {
			char tempChar = query.charAt(z);
			
			if (tempChar == ' ') {
				tempString += "%20";
			} else {
				tempString += tempChar;
			}
		}
		
		query = tempString;
		
		//Create url from the query given
		String jsonFile = "http://search.twitter.com/search.json?q=" + query + "%20filter:links" + "&lang=en&iso_language_code=en&include_entities=true&result_type=mixed";
	    
		//Read the json from the url and store it into a json object
		JSONObject json = new JSONObject();
		
		try {
			json = readJsonFromUrl(jsonFile);
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
			    
			    newResult.setProfile_image_url(jsonSection.getString("profile_image_url"));

			   //add it to the results database
			   results.add(newResult);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Sort results into most relevant (the links that are most referred to)
		
		
		//Display results
	
		String resultsHTML = convertResultsToHTML(results);
		
		req.setAttribute("twitterFeed", resultsHTML);
		
		//response.sendRedirect("/SearchResults.jsp"); redirect to another page
		
		req.getRequestDispatcher("/Search.jsp").forward(req, resp);
		
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
	
	public static String convertResultsToHTML(ArrayList<TwitterResults> results) {
		
		String htmlText = "<table border=" + '"' + "1" + '"' + " cellpadding=" + '"' + "5" + '"' + ">";
		
		for (int k = 0; k < results.size(); k++) {
		
			
			htmlText +="<TR>"
					 	+ "<TD>" + "<img src=" + '"' + results.get(k).getProfile_image_url() + '"' + ">"
					 	+ results.get(k).GetUserName() + "</TD>"
					 	+ "<TD>" + results.get(k).GetLinkedText() + "</TD>"
					 	+ "<TD>" + results.get(k).GetCreatedAt() + "</TD>"
					 	+ "</TR>";
			}
			htmlText += "</table>";
		
		
		return htmlText;
	}
	
}
