package com.wetterproject.wettersearch;

public class TwitterResults {
    private String text;
    private String from_user_name;
    private String geo;
    private String to_user_name;
    private String source;
    private String created_at;
    private String profile_image_url;
    private String url;
    private String result_type;
    private int retweets;
    
    public TwitterResults() {}
    		
    public String GetText() {return text;}
    
    public String GetLinkedText() {
    	
    	String linkedText = text;
    	
/*    	int startIndex = 0;
    	int endIndex = 0;
    	
    	String httpString = "http://t.co";
    	String httpStringLinked = "<a href=" + '"' + "http://t.co";
    	
    	startIndex = text.indexOf(httpString);
    	
    	boolean hasLink = text.contains(httpString);*/
    	String httpStringLinked = "";
    	
    	if (this.url != null) {
    		String link = this.url;
    		
    		httpStringLinked = "<a href=" + '"' + link + '"' + "/>";
    	
    		//linkedText.replace(link, httpStringLinked);
    		
    		linkedText.replaceAll(link, httpStringLinked);
    		
    	}
    	
    	
    	
    	
/*    	for (int i=0; i<text.length(); i++) {
    		
    		char tempChar = text.charAt(i);
    		
    		
    		
    		if (tempChar == 'h') {
    			startIndex = i;
    			
    			
    			CharSequence s = {'h', 't', 't', 'p', ':', '/', '/', 't', '.', 'c', 'o'};
				text.contains(s);
				
				
    		}
    		
    	}*/
    	
    	
    	return linkedText;
    }
    
    public String GetUserName() {return from_user_name;}
    
    public String GetCreatedAt() {return created_at;}
 
    public void setCreatedAt(String text) {
    	String tempString = "";
    	for (int i=0; i<text.length(); i++ ) {
    		char tempChar = text.charAt(i);
    		if (tempChar == '+') {
    			break;
    		}
    		tempString += tempChar;
    	}
    	
    	this.created_at = tempString;
    }

	public void setText(String text) {this.text = text;}
	
	public void setUserName(String text) {
		
		String tempString = "";
		
    	for (int i=0; i<text.length(); i++ ) {
    		char tempChar = text.charAt(i);
    		if (tempChar != '?') {
    			tempString += tempChar;
    		}
    	}
		
		this.from_user_name = tempString;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getTo_user_name() {
		return to_user_name;
	}

	public void setTo_user_name(String to_user_name) {
		this.to_user_name = to_user_name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResult_type() {
		return result_type;
	}

	public void setResult_type(String result_type) {
		this.result_type = result_type;
	}

	public int getRetweets() {
		return retweets;
	}

	public void setRetweets(int retweets) {
		this.retweets = retweets;
	}
    
}
