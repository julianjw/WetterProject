<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wetter Search</title>
</head>
<body>
<div id="wrapper" style="height: 800px; padding-left:25px; padding-right:25px; padding-bottom: 25px;">
<div> </div>
<div> </div>
<div id="google" align="left" style="width: 600px; height: 100%; float: left; padding-left: 25px;">

<!-- Google CSE Search Box Begins  -->
<!-- Use of this code assumes agreement with the Google Custom Search Terms of Service. -->
<!-- The terms of service are available at http://www.google.com/cse/docs/tos.html -->
<form id="cref_iframe" action="/Search.jsp">
  <input type="hidden" name="cref" value="http://wetter-search.appspot.com/cref_cse.xml" />
  <input type="hidden" name="cof" value="FORID:9" />
  <input type="text" name="q" id="googleQuery" size="40" />
  <input type="submit" name="sa" onclick="javascript: submitForm()" value="Search" />
</form>

<form id="submitQuery" action="/WetterSearch" method="post">
	<input type="text" name="q" id="twitterQuery" size="40" style="visibility: hidden;"/>
</form>

<script type="text/javascript" src="http://www.google.com/cse/brand?form=cref_iframe"></script>
<!-- Google CSE Search Box Ends -->

<div id="cse-search-results"></div>
<script type="text/javascript">
  var googleSearchIframeName = "cse-search-results";
  var googleSearchFormName = "cse-search-box";
  var googleSearchFrameWidth = 600;
  var googleSearchDomain = "www.google.com";
  var googleSearchPath = "/cse";
</script>
<script type="text/javascript" src="http://www.google.com/afsonline/show_afs_search.js"></script>

<SCRIPT TYPE="text/javascript">
function submitForm()
{
	
	var f = document.getElementById('cref_iframe');
	
	var q = f.
	var googleQuery = document.getElementById('googleQuery');
	var query = googleQuery.value;
	
/* 	oText = oForm.elements["text_element_name"]
	name = oForm.elements["name"].value; */
	
	var twitterQuery = document.getElementById('twitterQuery');
	twitterQuery.value = query;
	
	document.forms["submitQuery"].submit();
	
}
</SCRIPT>

</div>
<div id="twitter" align="right" style="width: 400px; float: right; padding-right: 25px;">
	${twitterFeed}
</div>
</div>
<!-- Place this tag where you want both of the search box and the search results to render -->

</body>
</html>