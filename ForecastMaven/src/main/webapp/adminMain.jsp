<%@page import="Model.Administrator"%>
<%@page import="DAO.DBManager"%>
<%@page import="Model.User"%>
<!DOCTYPE html>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/style.css"/>

</head>
<body>
    <%
            Administrator admin = (Administrator)session.getAttribute("admin");
    %>
    <script language="javascript">
        var LogoutTimer = function() {
        var session = {
            timer : null, limit : 1000 * 60 * 1,
            fnc   : function() {},
            start : function() {
                    session.timer = window.setTimeout(session.fnc, session.limit);
                    },
            reset : function() {
                    window.clearTimeout(session.timer);
                    session.start();
                    }
            };   
	document.onmousemove = function() { session.reset(); };
        return session;
      }();

      LogoutTimer.limit = 1000 * 60 * 1;
 
      LogoutTimer.fnc = function() {
        alert("Your session is invalid.");
        window.location = "LogoutServlet";
      }
 
      LogoutTimer.start();
      
    </script>

        <div class="sidenav">
            <br><br>
            <a href="adminMain.jsp">HOME</a>
            <a href="308_account_management_admin.jsp">ACCOUNT MANAGEMENT</a>
            
        </div>

        <div class="content">
            <br><br>
            <center>
            <div class="header">
                <h1>Weather Now</h1>
            </div>
            </center>
            
            <p align="center">Lulu lala I hope it wont be raining</p>
        <form action="AdminLogoutServlet" method="GET">
            <button type="submit" class="button">Logout</button>
        </form>
 

  <div class="w3-container w3-padding-32" id="projects">
      <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">Pages</h3>
  </div>

  <div class="w3-row-padding">
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">***</div>
        <img src="img/bus.JPG" alt="bus" style="width:100%">
      </div>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">***</div>
        <img src="img/snow.JPG" alt="snow" style="width:100%">
      </div>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">***</div>
        <img src="img/beach.JPG" alt="beach" style="width:100%">
      </div>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">***</div>
        <img src="img/thunder.JPG" alt="thunder" style="width:100%">
      </div>
    </div>
  </div>

  <div class="w3-row-padding">
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">***</div>
        <img src="img/rain.JPG" alt="rain" style="width:99%">
      </div>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">***</div>
        <img src="img/clean.JPG" alt="clean" style="width:99%">
      </div>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">***</div>
        <img src="img/cloud.JPG" alt="cloud" style="width:99%">
      </div>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">***</div>
        <img src="img/storm.JPG" alt="storm" style="width:99%">
      </div>
    </div>
  </div>
</div>
    </body>

    
    <jsp:include page="/ConnServlet" flush="true" />
</html>

