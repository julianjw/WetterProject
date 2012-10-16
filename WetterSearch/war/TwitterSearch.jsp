<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    
	<script>
// DOM Ready    
   $(function() {
 
		$.getJSON("http://api.flickr.com/services/feeds/photos_public.gne?ids=52723107@N00&lang=en-us&format=json&jsoncallback=?", function(data){
   	  $.each(data.items, function(index, item){
   		$("<img/>").attr("src", item.media.m).appendTo("#flickr")
   		  .wrap("<a href='" + item.link + "'></a>");
   	  });
   	});
   	
   	$.getJSON('http://twitter.com/status/user_timeline/chriscoyier.json?count=10&callback=?', function(data){
   		$.each(data, function(index, item){
   			$('#twitter').append('<div class="tweet"><p>' + item.text.linkify() + '</p><p><strong>' + relative_time(item.created_at) + '</strong></p></div>');
   		});
   	
   	});

/*  DEFUNCT
   	$.getJSON("http://www.scrnshots.com/users/chriscoyier/screenshots.json?callback=?", function(screenshots){
   		$.each(screenshots, function(index, screenshot){
   			$("#scrnshots").append("<a href='" + screenshot.url + "'><img src='" + screenshot.images.small + "' /></a>");
   		});
   	});
*/
   	
   	$.getJSON("http://api.dribbble.com/players/chriscoyier/shots?callback=?", function(data) {

   		$.each(data.shots, function(index, shot) {
   			$("#dribbble").append("<a href='" + shot.image_url + "'><img src='" + shot.image_teaser_url + "' /></a>");
   		});

   	});
   		    	
   	function relative_time(time_value) {
   	  var values = time_value.split(" ");
   	  time_value = values[1] + " " + values[2] + ", " + values[5] + " " + values[3];
   	  var parsed_date = Date.parse(time_value);
   	  var relative_to = (arguments.length > 1) ? arguments[1] : new Date();
   	  var delta = parseInt((relative_to.getTime() - parsed_date) / 1000);
   	  delta = delta + (relative_to.getTimezoneOffset() * 60);
   	  
   	  var r = '';
   	  if (delta < 60) {
   		r = 'a minute ago';
   	  } else if(delta < 120) {
   		r = 'couple of minutes ago';
   	  } else if(delta < (45*60)) {
   		r = (parseInt(delta / 60)).toString() + ' minutes ago';
   	  } else if(delta < (90*60)) {
   		r = 'an hour ago';
   	  } else if(delta < (24*60*60)) {
   		r = '' + (parseInt(delta / 3600)).toString() + ' hours ago';
   	  } else if(delta < (48*60*60)) {
   		r = '1 day ago';
   	  } else {
   		r = (parseInt(delta / 86400)).toString() + ' days ago';
   	  }
   	  
   	  return r;
   	}
   	
   	String.prototype.linkify = function() {
   		return this.replace(/[A-Za-z]+:\/\/[A-Za-z0-9-_]+\.[A-Za-z0-9-_:%&\?\/.=]+/, function(m) {
   			return m.link(m);
   		});
   	};
   	
   });
  </script>
</head>
<body>
	<form name="search" action="/TwitterSearch" method="post">
		<input type="text" name="query" id="query"/>
	</form>

		<div id="page-wrap">
	
		<div id="flickr">
		
			<h2>Flickr</h2>
		
		</div>
		
		<div id="twitter">
		
			<h2>Twitter</h2>
			
		</div>
		
		<div id="dribbble">
		
			<h2>Dribbble</h2>
		
		</div>
	
	</div>
	</body>
</html>