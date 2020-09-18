<%-- 
    Document   : 801_Location_Map
    Created on : 08/09/2020, 1:53:01 PM
    Author     : yujiwon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w2schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title class="title">Location Map Page</title>
    </head>
    <body>
        <form action="MapLocation_Servlet" method="POST">
            
            
        </form>
    
        <div class="sidenav">
            <br><br>
            <a href="index.html">HOME</a>
            <form name="submitForm" method="POST" action="CurrentWeather_Servlet">
            <input type="hidden" name="param1" value="param1Value">
            <a HREF="javascript:document.submitForm.submit()">CURRENT WEATHER</a>
            </form>
            <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
            <a href="601_weather_history.jsp">WEATHER HISTORY</a>
            <a href="801_Location_Map.jsp">LOCATION MAP</a>
            <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
        </div>
    </body>
    
</html>
