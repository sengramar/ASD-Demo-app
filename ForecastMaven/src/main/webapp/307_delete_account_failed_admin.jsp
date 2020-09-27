%-- 
    Document   : 304_delete_account_failed
    Created on : 2020. 9. 23, 오후 4:22:55
    Author     : hazel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Delete Failed</title>
    </head>
    <body>
         <h1 class="header">Failed Deleting the Account</h1>
        <p><a href="main.jsp" >Main page</a> </p>
            
        <div class="content"><a href="301_account_management.jsp" >Account Management page</a> </div>
        
        <div class="sidenav">
            <br><br>
            <a href="adminMain.jsp">HOME</a>
            <form name="submitForm" method="POST" action="CurrentWeather_Servlet">
            <input type="hidden" name="param1" value="param1Value">
            <a HREF="javascript:document.submitForm.submit()">CURRENT WEATHER</a></form>
            <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
            <a href="601_weather_history.jsp">WEATHER HISTORY</a>
            <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
            <a href="308_account_management_admin.jsp">ACCOUNT MANAGEMENT</a>
        </div>
    </body>
</html>
