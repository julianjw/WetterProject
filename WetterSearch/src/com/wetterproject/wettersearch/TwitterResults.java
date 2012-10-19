package com.wetterproject.wettersearch;

public class TwitterResults {
    private String text;
    private String from_user_id;
    private String from_user_name;
    private String geo;
    private String profile_image_url_https;
    private String iso_language_code;
    private String to_user_name;
    private String to_user_id;
    private String id;
    private String to_user_id_str;
    private String source;
    private String from_user_id_str;
    private String from_user;
    private String created_at;
    private String to_user;
    private String id_str;
    private String profile_image_url;
    private String metadata;
    
    private Entities entities;
    
    public TwitterResults() {}
    
    //entities={"urls":[{"expanded_url":"http://onforb.es/RTYtG9","indices":[45,65],"display_url":"onforb.es/RTYtG9","url":"http://t.co/8lPGuBd7"}]
    
    public static class Entities {
        private Urls urls;
        
        public Entities() {}

		public Urls getUrls() {
			return urls;
		}

		public void setUrls(Urls urls) {
			this.urls = urls;
		}
        
        // Add/generate getters and setters.
    }
    
    public static class Urls {
    	private String expanded_url;
        private int[] indices;
        private String display_url;
        private String url;
        
        public Urls() {}

		public String getExpanded_url() {
			return expanded_url;
		}

		public void setExpanded_url(String expanded_url) {
			this.expanded_url = expanded_url;
		}

		public int[] getIndices() {
			return indices;
		}

		public void setIndices(int[] indices) {
			this.indices = indices;
		}

		public String getDisplay_url() {
			return display_url;
		}

		public void setDisplay_url(String display_url) {
			this.display_url = display_url;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
    }
    		
    public String GetText() {return text;}
    
    public String GetUserName() {return from_user_name;}
    
    public String GetCreatedAt() {return created_at;}

	public void setText(String text) {this.text = text;}
	
	public void setUserName(String text) {this.from_user_name = text;}

	public String getFrom_user_id() {
		return from_user_id;
	}

	public void setFrom_user_id(String from_user_id) {
		this.from_user_id = from_user_id;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getProfile_image_url_https() {
		return profile_image_url_https;
	}

	public void setProfile_image_url_https(String profile_image_url_https) {
		this.profile_image_url_https = profile_image_url_https;
	}

	public String getIso_language_code() {
		return iso_language_code;
	}

	public void setIso_language_code(String iso_language_code) {
		this.iso_language_code = iso_language_code;
	}

	public String getTo_user_name() {
		return to_user_name;
	}

	public void setTo_user_name(String to_user_name) {
		this.to_user_name = to_user_name;
	}

	public String getTo_user_id() {
		return to_user_id;
	}

	public void setTo_user_id(String to_user_id) {
		this.to_user_id = to_user_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTo_user_id_str() {
		return to_user_id_str;
	}

	public void setTo_user_id_str(String to_user_id_str) {
		this.to_user_id_str = to_user_id_str;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getFrom_user_id_str() {
		return from_user_id_str;
	}

	public void setFrom_user_id_str(String from_user_id_str) {
		this.from_user_id_str = from_user_id_str;
	}

	public String getFrom_user() {
		return from_user;
	}

	public void setFrom_user(String from_user) {
		this.from_user = from_user;
	}

	public String getTo_user() {
		return to_user;
	}

	public void setTo_user(String to_user) {
		this.to_user = to_user;
	}

	public String getId_str() {
		return id_str;
	}

	public void setId_str(String id_str) {
		this.id_str = id_str;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public Entities getEntities() {
		return entities;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}
    
    //text, from_user_id, from_user_name, geo, profile_image_url_https, iso_language_code, to_user_name, to_user_id, id, to_user_id_str, source, from_user_id_str, from_user, created_at, to_user, id_str, profile_image_url, metadata

}
