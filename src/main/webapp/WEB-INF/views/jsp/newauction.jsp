<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<link href="resources/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<style>
#registration{
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
                   <a href="#" class="logo" title="Back to homepage"><img src="resources/images/CometSaleLogo_2.png" height="200px" width="200px" alt="logo"></a>
                </center>
              </h3>
              </div>
          </div>
      </div>
    </div>
  </div>
 </div>
</div>
                

	<h4><center>Enter the Product's Details that you want to sell</center></h4>
	<div id="registration">
	<center>
		<form action="successfulAddedProduct" method="post" enctype="multipart/form-data">
		<br><br>
		<table>
			<tr><td><h4>Product Name </h4></td><td><input type="text" name="productName" placeholder="Productname" pattern="[A-Za-z0-9 ]+" size="20" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>Product Description </h4></td><td><input type="text" name="productDescription" placeholder="ProductDescription" pattern="[A-Za-z ]+" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>Offer Price </h4></td><td><input type="text" name="offerPrice" placeholder="OfferPrice" pattern="[0-9]+" size="7" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>Quality </h4></td><td><input type="text" name="quality" placeholder="" pattern="[A-Za-z]+" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>Category </h4></td><td><input type="text" name="category" placeholder="category" pattern="[A-Za-z]+" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>StreetName </h4></td><td><input type="text" name="streetName" placeholder="user's streetName" pattern="[A-Za-z]+" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>Apartment Number </h4></td><td><input type="text" name="AptNo" placeholder="user's HouseNumber" pattern="[0-9]+" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>City </h4></td><td><input type="text" name="city" placeholder="user's City" size="14" pattern="[A-Za-z]+" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>State </h4></td><td><input type="text" name="state" placeholder="user's state" size="14" pattern="[A-Za-z]+" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>ZipCode </h4></td><td><input type="text" name="pinCode" placeholder="user's zipcode" pattern="[0-9]+" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>Image </h4></td><td><input type="file" name="image"/></td></tr>
		</table>
		<br>
			<input type="submit" value="Add Product"><br><br>
		</form>
	</center>
	</div>

<%@ include file="footer.jsp" %>
</body>
</html>