<%-- 
    Document   : 1111_WindSpeedMap
    Created on : 17 Sep, 2020, 10:32:42 AM
    Author     : krutipatel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Wind Speed Map</title>
    </head>
    <body>
        <%       
        String Location = (String) session.getAttribute("Location");
        String CurrentTempt = (String) session.getAttribute("CurrentTempt");
        String City = (String) session.getAttribute("City");
        String Country = (String) session.getAttribute("Country");
        String WindSpeed = (String) session.getAttribute("WindSpeed");
        String Description = (String) session.getAttribute("Description");
        String Celcius = (String) session.getAttribute("Celcius");
        %>
        <div class="content">
            <br><br>
            <div class="header">
                <h1>Wind Speed Map</h1>
            </div>
            <div style="border: 0px none; overflow: hidden; margin: 20px auto; max-width: 1200px;">
<iframe scrolling="no" src="https://openweathermap.org/weathermap?basemap=map&cities=true&layer=windspeed&lat=-25&lon=140&zoom=5" style="border: 0px none; margin-right: -200px; height: 1000px; margin-top: -200px; width: 1200px;">
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

