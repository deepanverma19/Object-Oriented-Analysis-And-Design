<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
<link href="resources/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<style>
#body{
  display: flex;
  min-height: 100vh;
  flex-direction: column;
}
</style>
    <script src="resources/js/jquery-1.10.2.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        
    </script>
</head>
<body>
<!-- header-->
<div class="container">
  <div class="row">
    <div class="span12">
      <div class="head">
        <div class="row-fluid">
            <div class="span12">
                <div class="span6">
                <h3 class="muted">
                <center>
                   <a href="#" class="logo" title="Back to homepage"><img src="resources/images/CometSaleLogo_2.png" height="350px" width="350px" alt="logo"></a>
                </center>
              </h3>
              </div>
          </div>
      </div>
    </div>
  </div>
 </div>
</div>
                
<h3><center>Welcome COMETS!!</center></h3>
<div id="body">
<center>
	<h2 style="color:red">${ERR_MSG}</h2>
	<form action="successfulLogin" method="post">
		<label>Username</label><input type="text" pattern="[a-z0-9]+" required="true" name="name"><br>
		<label>Password</label><input type="password" required="true" name="password"><br>
		<input type="submit" value="Login">
		<br><br>
		<a href="addUser" >New User? SignUp here</a>
	</form>
	</center>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
