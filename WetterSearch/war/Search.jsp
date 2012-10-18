<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Google Search</title>
<!-- Put the following javascript before the closing </head> tag. -->
<script>
  (function() {
    var cx = '010235793329395389058:8j2oz6hhiwe';
    var gcse = document.createElement('script'); gcse.type = 'text/javascript'; gcse.async = true;
    gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +
        '//www.google.com/cse/cse.js?cx=' + cx;
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(gcse, s);
  })();
</script>
</head>
<body>
<div id="google" align="left" style="width: 800px; float: left;">
	<gcse:search></gcse:search>
</div>

<div id="twitter" align="right" style="width: 400px; float: right;">
	Hello this is the twitter div.
</div>
<!-- Place this tag where you want both of the search box and the search results to render -->

</body>
</html>