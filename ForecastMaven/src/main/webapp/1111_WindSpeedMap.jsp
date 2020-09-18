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
            
            <h2> Currently in <%=City %>, <%=Country%> </h2>
            <h2> <%=Description %> </h2>
            <h2> Temperature <%=Celcius %> </h2>
            <h2> Wind Speed <%=WindSpeed %> </h2>
          
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

