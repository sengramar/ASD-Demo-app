<%-- 
    Document   : 202_logout
    Created on : 2020. 9. 8, 오후 2:28:49
    Author     : yses9
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/newcss.css"/>
        <title>Logout Page</title>
        <style>
        body {
            background-image: url("img/sub_bg.png");
            background-size: 100%;
            background-repeat: no-repeat;
        }
        </style>
    </head>
    <body>
           <a href="index.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a> 
            
            <a  HREF="javascript:document.CurrentWeather.submit()"><form class="nav_3" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet"><img src="img/nav_3_1.png" width="337"></form></a>
                
              
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>
            

            <h1 class="header">
            You have logged out
        </h1>
    <center>
        <h2> click <a href="index.jsp">here</a> to go to the home page.</h2>
    </center>
            <% 
                session.invalidate();
            %>
            </body>
</html>
