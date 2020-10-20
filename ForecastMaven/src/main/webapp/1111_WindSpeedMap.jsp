<%-- 
    Document   : 1111_WindSpeedMap
    Created on : 17 Sep, 2020, 10:32:42 AM
    Author     : krutipatel
--%>

<%@page import="Model.User"%>
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
        User user = (User)session.getAttribute("user");
        %>
        <div class="content">
            <br><br>
            <div class="header">
                <h1>Wind Speed Map</h1>
            </div>
            <div style="border: 0px none; overflow: hidden; margin: 50px; max-width: 1200px;">
<iframe scrolling="no" src="https://openweathermap.org/weathermap?basemap=map&cities=true&layer=windspeed&lat=-25&lon=140&zoom=5&appid={cf4da61b118dd75ceb61cd54e90b8930}" style="border: 0px none; height: 1100px; margin-top: -250px; width: 1200px;">
</iframe>              
</div>     
        <div class="sidenav">
            <br><br>
            <% if(user == null)
            {
            %>
            <a href="index.jsp">HOME</a>
            <%
            }
            else{
            %>
            <a href="main.jsp">HOME</a>
            <a href="301_account_management.jsp">ACCOUNT MANAGEMENT</a>
            <%}
            %>
            <form name="submitForm" method="POST" action="FirstCurrentWeather_Servlet">
            <a HREF="javascript:document.submitForm.submit()">CURRENT WEATHER</a></form>
            <form name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
            <a HREF="javascript:document.WeatherForecast.submit()">WEATHER FORECAST</a></form>
            <!--
            <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
            <a href="601_weather_history.jsp">WEATHER HISTORY</a>
            <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
            -->
            <a href="1111_WindSpeedMap.jsp">WIND SPEED MAP</a>
        </div>
            
        </div>
    </body>
</html>

