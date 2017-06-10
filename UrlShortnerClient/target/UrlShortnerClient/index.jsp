<%@ page import="com.lm.util.UrlConst" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Logic Monitor  WebServices</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
  <h1>LogicMonitor </h1>
 
 <h3>RESTFull UrlShortner Services</h3>
 
   <div class="alert alert-danger">
    
    <%
if(request.getAttribute(UrlConst.FRM_ERR_MSG) != null){
	out.print(request.getAttribute(UrlConst.FRM_ERR_MSG));
}
    
 %>
  </div>
 
 <div id="lm" style="  position: fixed; top: 50%; left: 50%;transform: translate(-50%, -50%);">
  <ul class="nav nav-pills">
    <li class="active"><a data-toggle="pill" href="#home">URL Shortner</a></li>
    <li><a data-toggle="pill" href="#menu1">URL Expander</a></li>
    
  </ul>
  

  
  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
     <form name="TinyServletForm" action="TinyServlet" method="post">
  <div class="form-group">
    
    <input type="text" class="form-control" id="formGroupExampleInput" name="expandTxt" placeholder="Enter url to shorten">
  </div>
  <div class="form-group">
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
 
</form>
      
      
    </div>
    <div id="menu1" class="tab-pane fade">
      
      
      <form name="ExpandServletForm" action="ExpandServlet" method="post">

		 <div class="form-group">
    
    <input type="text" class="form-control" id="formGroupExampleInput" name="tinyTxt" placeholder="Enter url to expand">
  </div>
  <div class="form-group">
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
		
			
	</form>
    </div>
  
  </div>
</div>
<div class="wrapper" style="position: relative;">

<%
if(request.getAttribute(UrlConst.FRM_SHOW_LONGURL_1) != null){%>
<div class="alert alert-success" id="div1" style="position:absolute">
  <label>LongUrl: </label><span><%out.println(request.getAttribute(UrlConst.FRM_SHOW_LONGURL_1));
	}
%>
</span>
	</br>
  <%if(request.getAttribute(UrlConst.FRM_SHOW_TINYURL_1) != null){%>
  <label>TinyUrl: </label><span><%out.println(request.getAttribute(UrlConst.FRM_SHOW_TINYURL_1));
	} %></span>
	</div>

<% if(request.getAttribute(UrlConst.FRM_SHOW_LONGURL_2) != null){%>
<div class="alert alert-success" id="div2" style="position:absolute">
			<label>LongUrl: </label><span><% out.println(request.getAttribute(UrlConst.FRM_SHOW_LONGURL_2)); 
			}
			%></span></br>	
			<%
			if(request.getAttribute(UrlConst.FRM_SHOW_TINYURL_2) != null){%>
			  <label>TinyUrl: </label><span><%out.println(request.getAttribute(UrlConst.FRM_SHOW_TINYURL_2));
			}%></span>
						
		</div>
</div>
</div>

</body>
</html>