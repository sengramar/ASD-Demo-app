<%-- 
    Document   : 1112_PrecipitationMap
    Created on : 14 Oct, 2020, 11:48:22 AM
    Author     : krutipatel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Precipitation Map</title>
    </head>
    <body>
        
        <div class="content">
            <br><br>
            <div class="header">
                <h1>Precipitation Map</h1>
            </div>
            <div style="border: 0px none; overflow: hidden; margin: 50px; max-width: 1200px;">
<iframe scrolling="no" src="https://openweathermap.org/weathermap?basemap=map&cities=true&layer=precipitation&lat=-25&lon=140&zoom=5&appid={cf4da61b118dd75ceb61cd54e90b8930}" style="border: 0px none; height: 1100px; margin-top: -250px; width: 1200px;">
</iframe>              
</div>     
            <div class="sidenav">
                <br><br>
                <a href="index.html">HOME</a>
                <form name="submitForm" method="POST" action="CurrentWeather_Servlet">
                <input type="hidden" name="param1" value="param1Value">
                <a HREF="javascript:document.submitForm.submit()">CURRENT WEATHER</a></form>
                <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
                <a href="601_weather_history.jsp">WEATHER HISTORY</a>
                <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
                <a href="1111_WindSpeedMap.jsp">Wind Speed Map</a>
            </div> 
            
        </div>
    </body>
</html>

