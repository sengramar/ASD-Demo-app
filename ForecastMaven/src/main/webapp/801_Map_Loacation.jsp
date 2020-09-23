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
                    <input type="hidden" name="LocationID" value=101>
                    <input type="hidden" name="State" value="NSW">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Sydney" style="position: absolute; bottom:280px; right:130px;">
                    
                    <input type="hidden" name="LocationID" value=102>
                    <input type="hidden" name="State" value="NSW">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Newcastle" style="position: absolute; bottom:320px; right:110px; ">
                    
                    <input type="hidden" name="LocationID" value=103>
                    <input type="hidden" name="State" value="NSW">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Wollongong" style="position: absolute; bottom:260px; right:120px; ">
                    
                    <input type="hidden" name="LocationID" value=104>
                    <input type="hidden" name="State" value="NSW">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Central Coast" style="position: absolute; bottom:300px; right:100px; ">
                    
                    
                    <%-- ACT--%>
                    <input type="hidden" name="LocationID" value=201>
                    <input type="hidden" name="State" value="ACT">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Canberra" style="position: absolute; bottom:240px; right:175px; ">
                   
                    
                    <%-- QLD --%>
                    <input type="hidden" name="LocationID" value=301>
                    <input type="hidden" name="State" value="QLD ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Brisbane" style="position: absolute; bottom:420px; right:80px; ">
                   
                    <input type="hidden" name="LocationID" value=302>
                    <input type="hidden" name="State" value="QLD ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Gold Coast" style="position: absolute; bottom:405px; right:90px;">
                   
                    <input type="hidden" name="LocationID" value=303>
                    <input type="hidden" name="State" value="QLD ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Sunshine Coast" style="position: absolute; bottom:435px; right:100px;">
                   
                    <input type="hidden" name="LocationID" value=304>
                    <input type="hidden" name="State" value="VIC ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Townsville" style="position: absolute; top:200px; right:210px;">
                   
                    <input type="hidden" name="LocationID" value=305>
                    <input type="hidden" name="State" value="VIC ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Cairns" style="position: absolute; top:150px; right:235px;">
                   
                    <input type="hidden" name="LocationID" value=306>
                    <input type="hidden" name="State" value="VIC ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Cooktown" style="position: absolute; top:125px; right:250px;">
                   
                    <input type="hidden" name="LocationID" value=307>
                    <input type="hidden" name="State" value="VIC ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Mackay" style="position: absolute; top:240px; right:160px;">
                   
                    <input type="hidden" name="LocationID" value=308>
                    <input type="hidden" name="State" value="VIC ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Rockhamton" style="position: absolute; top:280px; right:130px;">
                   
                    
                    <%-- VIC --%>
                    
                    <input type="hidden" name="LocationID" value=401>
                    <input type="hidden" name="State" value="VIC ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Melbourne" style="position: absolute; bottom:200px; right:230px; ">
                   
                    <input type="hidden" name="LocationID" value=402>
                    <input type="hidden" name="State" value="VIC ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Geelong" style="position: absolute; bottom:190px; right:255px;">
                   
                    <input type="hidden" name="LocationID" value=403>
                    <input type="hidden" name="State" value="VIC ">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Warrnambool" style="position: absolute; bottom:180px; right:275px;">
                   
                    
                    
                    <%-- NT --%>
                    <input type="hidden" name="LocationID" value=501>
                    <input type="hidden" name="State" value="NT">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Darwin" style="position: absolute; top:60px; right:510px; ">
                   
                    <input type="hidden" name="LocationID" value=502>
                    <input type="hidden" name="State" value="NT">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Alice Springs" style="position: absolute; top:300px; right:450px; ">
                   
                    <input type="hidden" name="LocationID" value=503>
                    <input type="hidden" name="State" value="NT">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Tennant Creek" style="position: absolute; top:200px; right:445px;">

                    <%-- SA --%>
                    <input type="hidden" name="LocationID" value=601>
                    <input type="hidden" name="State" value="SA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Adelaide" style="position: absolute; bottom:260px; right:370px; ">
                   
                    <input type="hidden" name="LocationID" value=602>
                    <input type="hidden" name="State" value="SA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Ceduna" style="position: absolute; bottom:320px; right:450px;">
                  
                    <input type="hidden" name="LocationID" value=603>
                    <input type="hidden" name="State" value="SA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Whyalla" style="position: absolute; bottom:280px; right:400px;">
                  
                    <input type="hidden" name="LocationID" value=604>
                    <input type="hidden" name="State" value="SA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Marla" style="position: absolute; bottom:400px; right:460px;">
                  
                    <%-- WA --%>
                    
                    <input type="hidden" name="LocationID" value=701>
                    <input type="hidden" name="State" value="WA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Perth" style="position: absolute; bottom:320px; left:150px; ">
                   
                    <input type="hidden" name="LocationID" value=702>
                    <input type="hidden" name="State" value="WA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Geraldton" style="position: absolute; bottom:380px; left:130px;">
                    
                    <input type="hidden" name="LocationID" value=703>
                    <input type="hidden" name="State" value="WA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Esperance" style="position: absolute; bottom:275px; left:240px; ">
                  
                    <input type="hidden" name="LocationID" value=704>
                    <input type="hidden" name="State" value="WA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Broome" style="position: absolute; top:170px; left:270px; ">
                    
                    <input type="hidden" name="LocationID" value=705>
                    <input type="hidden" name="State" value="WA">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Karratha" style="position: absolute; top:225px; left:200px; ">
                    
                    <%-- TAS --%>
                    <input type="hidden" name="LocationID" value=801>
                    <input type="hidden" name="State" value="TAS">
                    <input type="hidden" name="Country" value="AU">
                    <input type="submit" name="Region" readonly="True" value="Hobart" style="position: absolute; bottom:90px; right:200px; ">
                  
                    <input type="hidden" name="LocationID" value=802>
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
            <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
            <a href="601_weather_history.jsp">WEATHER HISTORY</a>
            <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
        </div>

    </body>
    
</html>
