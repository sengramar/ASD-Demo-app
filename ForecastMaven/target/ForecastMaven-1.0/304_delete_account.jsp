<%-- 
    Document   : 304_delete_account
    Created on : 2020. 9. 23, 오후 4:16:39
    Author     : hazel
--%>

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/newcss.css"/>
        <title>Delete Succeed</title>
        <style>
            body {
                background-image: url("img/sub_bg.png");
                background-size: 100%;
                background-repeat: no-repeat;
            }
        </style>
    </head>
    <body>

            <% 
                User user = (User)session.getAttribute("user");
                if(user == null)
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
            

            <a  HREF="javascript:document.CurrentWeather.submit()"><form class="nav_1" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet"><img src="img/nav_1.png" width="340"></form></a>
                
                
            <form  class="nav_2" name="WeatherHistory" method="POST" action="FirstWeatherHistory_Servlet">
                <a  HREF="javascript:document.WeatherHistory.submit()"><img src="img/nav_2.png" width="340"></a></form>
            
            <form class="nav_3" name="WeatherAnalysis" method="POST" action="WeatherAnalysis_Servlet">
                <a  HREF="javascript:document.WeatherAnalysis.submit()"><img src="img/nav_3.png" width="341"></a></form>
            
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_5" ></a>
   
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_7.png" class="nav_6" ></a>
            


        
    <center>
        <img class="heading_img" src="img/heading_account_deleted.png">
        <div class="regbox"> You have logged out.<br>click <a href="index.jsp">here</a> to go to the home page.</div>
    </center>
            <% 
                session.invalidate();
            %>
            </body>
</html>
