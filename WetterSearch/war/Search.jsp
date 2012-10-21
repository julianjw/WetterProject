<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wetter Search</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link type="text/css" rel="stylesheet" href="/style.css" />
</head>
<body>

<!-- Place this tag where you want both of the search box and the search results to render -->

	<div class="wrapper">
		
		<!-- header section -->
		<div id="masthead">
			<h1 align="center">Wetter Search</h1>
			<div align="center">
				<form id="cref_iframe" action="/WetterSearch">
	  				<input type="hidden" name="cref" value="http://wetter-search.appspot.com/cref_cse.xml" />
		  			<input type="hidden" name="cof" value="FORID:9" />
	  				<input type="text" name="q" id="googleQuery" size="40" />
	  				<input type="submit" name="sa" onclick="myFunction()" value="Search" />
				</form>
	
				<form id="submitQuery" action="/WetterSearch">
					<input type="text" name="q" id="twitterQuery" size="40" style="visibility: hidden;"/>
				</form>
			</div>
		</div>
		
		<!-- Content section -->
		<div class="content">
		
			<!-- Content header -->
			<div>
			</div>
			
			<div>
			
				<!-- page content -->
<div id="wrapper" style="height: 100%; padding-left:25px; padding-right:25px; padding-bottom: 25px;">
<div> </div>
<div> </div>
<div id="google" align="left" style="width: 40%; height: 200px; float: left; max-width: 50%; max-height: 600px;">

<script>
function myFunction()
{
document.getElementById("twitter").innerHTML="Hello World";

var f = document.getElementById('cref_iframe');

var googleQuery = document.getElementById('googleQuery');
var query = googleQuery.value;

/* 	oText = oForm.elements["text_element_name"]
name = oForm.elements["name"].value; */

var twitterQuery = document.getElementById('twitterQuery');
twitterQuery.value = query;

document.getElementById("submitQuery").submit();
}
</script>

<!-- Google CSE Search Box Begins  -->
<!-- Use of this code assumes agreement with the Google Custom Search Terms of Service. -->
<!-- The terms of service are available at http://www.google.com/cse/docs/tos.html -->


<!-- Google CSE Search Box Ends -->
<script type="text/javascript" src="http://wetter-search.appspot.com/brand?form=cref_iframe"></script>

<div id="cse-search-results"></div>
<script type="text/javascript">
  var googleSearchIframeName = "cse-search-results";
  var googleSearchFormName = "cse-search-box";
  var googleNumSearchResults = 10;
  var googleSearchFrameWidth = 550;
  var googleSearchFrameHeight = 1100;
  var googleSearchDomain = "www.google.com";
  var googleSearchPath = "/cse";
  var googleSearchResizeIframe = true;
</script>
<script type="text/javascript" src="http://www.google.com/afsonline/show_afs_search.js"></script> 
 <script type="text/javascript">
 	try{document.getElementsByName('googleSearchFrame')[0].height=1100;}catch(e){}
 	try{document.getElementsByName('googleSearchFrame')[0].width=600;}catch(e){}
</script>
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
<div id="twitter" align="right" style="width: 600px; float: right;">
	${twitterFeed}
</div>
</div>
				
			</div>				
			
			<div style='clear:both;'></div>
			
		</div>
		
		<!-- footer section -->
		<div class="footer"></div>	
					
	</div> <!-- end wrapper -->  

</body>
</html>