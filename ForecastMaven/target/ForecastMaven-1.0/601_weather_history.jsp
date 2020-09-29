<%-- 
    Document   : 601_weather_history
    Created on : 2020. 8. 25, 오전 11:18:31
    Author     : soyoung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Weather History Page</title>
    </head>
    <body>
        <div class="content">
            <br><br>
            <div class="header"> <h1>Weather History</h1></div>
            
        <div class="sidenav">
            <br><br>
            <a href="index.html">HOME</a>
            <form name="submitForm" method="POST" action="FirstCurrentWeather_Servlet">
            <a HREF="javascript:document.submitForm.submit()">CURRENT WEATHER</a></form>
            <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
            <a href="601_weather_history.jsp">WEATHER HISTORY</a>
            <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
        </div>
            
        </div>
    </body>
</html>
