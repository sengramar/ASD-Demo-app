<%@page import="Model.Administrator"%>
<%@page import="DAO.DBManager"%>
<%@page import="Model.User"%>
<!DOCTYPE html>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/newcss.css"/>
<style>
body {
            background-image: url("img/main_bg.png");
            background-size: 100%;
            background-repeat: no-repeat;
        }
        </style>
</head>
<body>
    
<script language="javascript">
        var LogoutTimer = function() {
        var session = {
            timer : null, limit : 1000 * 60 * 20,
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

      LogoutTimer.limit = 1000 * 60 * 20;
 
      LogoutTimer.fnc = function() {
        alert("Your session is invalid.");
        window.location = "LogoutServlet";
      }
 
      LogoutTimer.start();
      
</script>

    <%
            Administrator admin = (Administrator)session.getAttribute("admin");
            DBManager manager = (DBManager)session.getAttribute("manager"); 
            String email = request.getParameter("Email");
            String password = request.getParameter("Password");
    %>
    
    

       <a  class="account" href="308_account_management_admin.jsp"><img src="img/account_btn.png" width="185"></a>
    <form action="AdminLogoutServlet" method="GET">
            <button type="submit" class="logout"><img src="img/logout_btn.png" width="110"></button>
        </form>   
        
        

    <form name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet">
    <a class="current_weather" HREF="javascript:document.CurrentWeather.submit()"><img src="img/current_weather.png" width="180"></a></form>
    
        
    <a class="weather_forecast" href="501_weather_forecast.jsp"><img src="img/weather_forecast.png" width="180"></a>
    
    
    <form name="WeatherHistory" method="POST" action="FirstWeatherHistory_Servlet">
    <a class="weather_history" HREF="javascript:document.WeatherHistory.submit()"><img src="img/weather_history.png" width="180"></a></form>
    
    
    <form name="WeatherAnalysis" method="POST" action="WeatherAnalysis_Servlet">
    <a class="weather_analysis" HREF="javascript:document.WeatherAnalysis.submit()"><img src="img/weather_analysis.png" width="180"></a></form>
    
    
    <a class="wind_speed_map" href="1111_WindSpeedMap.jsp"><img src="img/wind_speed_map.png" width="185"></a>    
            
    </body>

    
    <jsp:include page="/ConnServlet" flush="true" />
</html>

