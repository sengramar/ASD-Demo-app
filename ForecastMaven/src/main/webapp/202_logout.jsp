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
        <link rel="stylesheet" href="css/style.css"/>
        <title>Logout Page</title>
    </head>
    <body>
        <h1 class="header">
            You have logged out
        </h1>
    <center>
        <h2> click <a href="main.jsp">here</a> to go to the home page.</h2>
    </center>
            <% 
                session.invalidate();
            %>
            
            <div class="sidenav">
            <br><br>
            <a href="main.jsp">HOME</a>
            <form name="submitForm" method="POST" action="CurrentWeather_Servlet">
            <input type="hidden" name="param1" value="param1Value">
            <a HREF="javascript:document.submitForm.submit()">CURRENT WEATHER</a></form>
            <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
            <a href="601_weather_history.jsp">WEATHER HISTORY</a>
            <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
            <a href="301_account_management.jsp">ACCOUNT MANAGEMENT</a>
        </div>
    </body>
</html>
