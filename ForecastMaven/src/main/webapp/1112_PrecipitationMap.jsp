<%-- 
    Document   : 1112_PrecipitationMap
    Created on : 14 Oct, 2020, 11:48:22 AM
    Author     : krutipatel
--%>

<%@page import="Model.Administrator"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/newcss.css"/>
        
        <style>
        body {
            background-image: url("img/sub_bg.png");
            background-size: 100%;
            background-repeat: repeat;
        }
        </style>
        <title>Precipitation Map</title>
    </head>
    
    
    <body>
        <%       
        User user = (User)session.getAttribute("user");
        Administrator admin = (Administrator)session.getAttribute("admin");
        %>
        <div class="content">
            <br><br>
            <div class="header">
                <h1>Precipitation Map</h1>
            </div>
            <div style="border: 0px none; overflow: hidden; margin: 50px; max-width: 1200px;">
<iframe scrolling="no" src="https://openweathermap.org/weathermap?basemap=map&cities=true&layer=precipitation&lat=-25&lon=140&zoom=5&appid={cf4da61b118dd75ceb61cd54e90b8930}" style="border: 0px none; height: 1100px; margin-top: -250px; width: 1200px;">
</iframe>              
</div>     
            <% if(user == null)
            {
            %>
            <a href="index.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>
            <%
            }
            else{
            %>
            <a href="main.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>
            <%}
            %>
            <a href="main.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>

            
            <a  HREF="javascript:document.CurrentWeather.submit()"><form class="nav_1" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet"><img src="img/nav_current_weather.png" width="337"></form></a>
          <a  HREF="javascript:document.CurrentWeather.submit()"><form class="nav_1" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet"><img src="img/nav_1.png" width="340"></form></a>
                
                
            <form  class="nav_2" name="WeatherHistory" method="POST" action="FirstWeatherHistory_Servlet">
                <a  HREF="javascript:document.WeatherHistory.submit()"><img src="img/nav_2.png" width="340"></a></form>
            
            <form class="nav_3" name="WeatherAnalysis" method="POST" action="WeatherAnalysis_Servlet">
                <a  HREF="javascript:document.WeatherAnalysis.submit()"><img src="img/nav_3.png" width="341"></a></form>
            
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_5" ></a>
   
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_7.png" class="nav_6" ></a>
            

        
        </div>
    </body>
</html>

