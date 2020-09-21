<%-- 
    Document   : 801_Location_Map
    Created on : 08/09/2020, 1:53:01 PM
    Author     : yujiwon
--%>
<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w2schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>    
        <style> 
        input[type=submit]
        {
            background-color: transparent;
            border: none;
            color: black;
            text-decoration: none;
            margin: 4px 2px;
            
        
        }
        input[type=submit]:hover
        {
            background-color: #ffffff;
            color: red;
            border: none;
            text-decoration: underline overline;
            margin: 4px 2px;
            opacity: 0.5px;
        }
        </style>
        <title class="title">Location Map Page</title>
        
    </head>
    <body>
        <div class="content">
             <div class="map" style="background-image: url(img/AussieMap.JPG); background-repeat:no-repeat; background-size: contain; position:relative;">
                 
                <form method="post" action="LocationMap_Servlet">
           
                    <%-- NSW --%>
                    <input type="hidden" name="LocationID" value=1>
                    <input type="hidden" name="State" value="NSW">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Sydney" style="position: absolute; bottom:280px; right:130px;">
                    
                    <input type="hidden" name="LocationID" value=4>
                    <input type="hidden" name="State" value="NSW">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Newcastle" style="position: absolute; bottom:320px; right:110px; ">
                    
                    <input type="hidden" name="LocationID" value=5>
                    <input type="hidden" name="State" value="NSW">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Wollongong" style="position: absolute; bottom:260px; right:120px; ">
                    
                    <input type="hidden" name="LocationID" value=6>
                    <input type="hidden" name="State" value="NSW">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Central Coast" style="position: absolute; bottom:300px; right:100px; ">
                    
                    <input type="hidden" name="LocationID" value=19>
                    <input type="hidden" name="State" value="NSW">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Broken Hill" style=" position: absolute; bottom:320px; right:300px; ">
                   
                    <%-- ACT--%>
                    <input type="hidden" name="LocationID" value=3>
                    <input type="hidden" name="State" value="ACT">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Canberra" style="position: absolute; bottom:240px; right:175px; ">
                   
                    
                    <%-- QLD --%>
                    <input type="hidden" name="LocationID" value=7>
                    <input type="hidden" name="State" value="QLD ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Brisbane" style="position: absolute; bottom:420px; right:80px; ">
                   
                    <input type="hidden" name="LocationID" value=9>
                    <input type="hidden" name="State" value="QLD ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Gold Coast" style="position: absolute; bottom:405px; right:90px;">
                   
                    <input type="hidden" name="LocationID" value=16>
                    <input type="hidden" name="State" value="QLD ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Sunshine Coast" style="position: absolute; bottom:435px; right:100px;">
                   
                    <%-- VIC --%>
                    
                    <input type="hidden" name="LocationID" value=2>
                    <input type="hidden" name="State" value="VIC ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Melbourne" style="position: absolute; bottom:200px; right:230px; ">
                   
                    <input type="hidden" name="LocationID" value=8>
                    <input type="hidden" name="State" value="VIC ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Geelong" style="position: absolute; bottom:190px; right:255px;">
                   
                    <input type="hidden" name="LocationID" value=21>
                    <input type="hidden" name="State" value="VIC ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Warrnambool" style="position: absolute; bottom:180px; right:275px;">
                   
                    <%-- NT --%>
                    <input type="hidden" name="LocationID" value=20>
                    <input type="hidden" name="State" value="NT">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Alice Springs" style="position: absolute; top:300px; right:450px; ">
                   
                    <input type="hidden" name="LocationID" value=17>
                    <input type="hidden" name="State" value="NT">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Tennant Creek" style="position: absolute; top:200px; right:445px;">

                    <%-- SA --%>
                    <input type="hidden" name="LocationID" value=12>
                    <input type="hidden" name="State" value="SA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Adelaide" style="position: absolute; bottom:260px; right:370px; ">
                   
                    <input type="hidden" name="LocationID" value=13>
                    <input type="hidden" name="State" value="SA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Ceduna" style="position: absolute; bottom:320px; right:450px;">
                   
                    <%-- WA --%>
                    <input type="hidden" name="LocationID" value=11>
                    <input type="hidden" name="State" value="WA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Perth" style="position: absolute; bottom:320px; left:150px; ">
                   
                    <input type="hidden" name="LocationID" value=10>
                    <input type="hidden" name="State" value="WA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Geraldton" style="position: absolute; bottom:380px; left:130px;">
                    
                    <input type="hidden" name="LocationID" value=18>
                    <input type="hidden" name="State" value="WA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Esperance" style="position: absolute; bottom:275px; left:240px; ">
                  
                    <%-- TAS --%>
                    <input type="hidden" name="LocationID" value=14>
                    <input type="hidden" name="State" value="TAS">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Hobart" style="position: absolute; bottom:90px; right:200px; ">
                  
                     <input type="hidden" name="LocationID" value=15>
                    <input type="hidden" name="State" value="TAS">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Launceston" style="position: absolute; bottom:120px; right:200px; ">
                  
                    
                </form>
                 
             </div>
       
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
