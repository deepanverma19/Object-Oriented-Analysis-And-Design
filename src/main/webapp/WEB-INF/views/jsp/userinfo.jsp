<!DOCTYPE html>
<!-- saved from url=(0054)http://bootsnipp-env.elasticbeanstalk.com/iframe/9XRdX -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import ="com.cometsale.controller.UserController" %>
<%@ page import="java.util.Date"%>
    
    <meta name="robots" content="noindex">

    <title>User Profile Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resources/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    
    <style type="text/css">
    .user-row {
    margin-bottom: 14px;
}

.user-row:last-child {
    margin-bottom: 0;
}

.dropdown-user {
    margin: 13px 0;
    padding: 5px;
    height: 100%;
}

.dropdown-user:hover {
    cursor: pointer;
}

.table-user-information > tbody > tr {
    border-top: 1px solid rgb(221, 221, 221);
}

.table-user-information > tbody > tr:first-child {
    border-top: 0;
}


.table-user-information > tbody > tr > td {
    border-top: 0;
}
.toppad
{margin-top:20px;
}

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="resources/js/jquery-1.10.2.min.js"></script>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'http://bootsnipp.com');
        });
    </script>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="span12">
      <div class="head">
        <div class="row-fluid">
            <div class="span12">
             <div class="span6">
              <h3 class="muted">
                   <a href="#" class="logo" title="Back to homepage"><img src="resources/images/CometSaleLogo_2.png" height="200px" width="200px" alt="logo"></a>
              </h3>
          </div>
        </div>
      </div>
    </div>
  </div>
 </div>
</div>

<div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <ul class="nav">
                        <li>
                            <a href="homepage">Home</a>
                        </li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="addProduct">Add Product</a>
                        </li>
						<li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="viewProfile">View Profile</a>
                        </li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="viewWishlist">View WishList</a>
                        </li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="contactus">Contact Us</a>
                        </li>
                        
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        
                        <li>
                        <form id="search" style="margin:9px" action="availableauctions">
                        <a href="#" style="color:#777777">Search</a>
                        <input type="text">
                        </form>
                        </li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

	<div class="container">
      <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">${userDetails.getFirstName()} </h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="resources/images/user.jpg" class="img-circle img-responsive"> </div>
               
                <div class=" col-md-9 col-lg-9 "> 
                <center>
                <h2 style="color:red">${ERR_MSG}</h2>
                <form action="editdetails" method="get">
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>NetID:</td>
                        <td>${user.getNetid()}</td>
                      </tr>
                      <tr>
                        <td>FirstName:</td>
                        <td>${userDetails.getFirstName()}</td>
                      </tr>
                      <tr>
                        <td>LastName:</td>
                        <td>${userDetails.getLastName()}</td>
                      </tr>
                      <tr>
                        <td>User Address:</td>
                        <td>${userDetails.getHomeAddress().getStreetname()},&nbsp;${userDetails.getHomeAddress().getAptNo()},&nbsp;${userDetails.getHomeAddress().getCity()},<br>
                        ${userDetails.getHomeAddress().getState()},&nbsp;${userDetails.getHomeAddress().getPinCode()}</td>
                      </tr>
             		  <tr>
                        <td>PhoneNumber:</td>
                        <td>${userDetails.getPhoneNumber()}</td>
                      </tr>
                      <tr>
                        <td>Email:</td>
                        <td>${userDetails.getEmail()}</td>
                      </tr>
                    </tbody>
                  </table>
                  <input type="submit" value="Edit Profile">
                  </form>
                  </center>
                </div>
              </div>
            </div>
                 
            
          </div>
        </div>
      </div>
    </div>
	

<%@ include file="footer.jsp" %>
</body></html>