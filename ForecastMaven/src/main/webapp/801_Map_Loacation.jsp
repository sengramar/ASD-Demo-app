<%-- 
    Document   : 801_Location_Map
    Created on : 08/09/2020, 1:53:01 PM
    Author     : yujiwon
--%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w2schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>        
        <title class="title">Location Map Page</title>
    </head>
    <body>
        <div class="content">
        
        <form method="post" action="SelectLocation_Servlet">
            
            <img class="resize" src="img/AussieMap.JPG">
            <p>NSW</p>
            <p>Sydney</p>
            <p>Newcastle</p>
            <p>Central Coast</p>
            <p>Wollongong</p>
            
            <br>
                
            <p>ACT</p>
            <p>Canberra</p>
            
            <br>
            <p>QLD</p>
            <p>Brisbane</p>
            <p>Gold Coast</p>
            <p>Sunshine Coast</p>
            
            <br>
            <p>VIC</p>
            <p>Melbourne</p>
            <p>Geelong and Surf Coast</p>
            <p>Mornington Peninsula</p>
            
            <br>
            
            <p>NT</p>
            <p>Darwin</p>
            <p>Alice Springs</p>
            
            <br>
            
            <p>SA</p>
            <p>Adelaide</p>
            
            <p>WA</p>
            <p>Perth</p>
            
        </form>
        </div>       
        <div class="sidenav">
            <br><br>
            <a href="index.html">HOME</a>
            <form name="submitForm" method="POST" action="CurrentWeather_Servlet">
            <input type="hidden" name="param1" value="param1Value">
            <a HREF="javascript:document.submitForm.submit()">CURRENT WEATHER</a>
            </form>
            <a href="801_Location_Map.jsp">LOCATION MAP</a>
            <a href="701_List_Location.jsp">LOCATION LIST</a>
            <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
            <a href="601_weather_history.jsp">WEATHER HISTORY</a>
            <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
        </div>

    </body>
    
</html>
