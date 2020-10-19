<%-- 
    Document   : 501_weather_forecast
    Created on : 2020. 8. 25, 오전 11:18:18
    Author     : soyoung
--%>
<%@page import="Model.*"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Weather Forecast Page</title>
        <style>
            ul {float:left;}
            ul li {list-style-type: none;}
        </style>
    </head>

    <body>
        <div class="content">
            <br><br>
            <div class="header">
                <h1>Weather Forecast</h1>
            </div>
        <%
            User user = (User)session.getAttribute("user");
            String City = (String) session.getAttribute("City");
            String Country = (String) session.getAttribute("Country");
        %>
             <h2><%=City %>, <%=Country%></h2>
        <%      
            LinkedList<WeatherForecast> forecast  = (LinkedList) session.getAttribute("forecast");
            for(int i =0; i<forecast.size(); i++){
        %> 
<!--            <form action="WeatherForecast_Servlet" method="POST">-->
           <div class="nav">
            <div>
                <ul>
                <h3><%= forecast.get(i).getDate() %></h3>
                <li><B>TEMPERATURE</B> <%= forecast.get(i).getTemp() %></li>
                <li><B>HUMIDITY</B> <%= forecast.get(i).getHumidity() %>%</li>
                <li><B>CLOUDINESS</B> <%= forecast.get(i).getCloudy() %>% </li>
                <li><B>WIND SPEED</B> <%= forecast.get(i).getWindSpeed() %>m/s </li>
                <li><B>WIND DEGREE</B> <%= forecast.get(i).getWindDegree() %> </li>
                <li><%= forecast.get(i).getDescription() %> </li>
                </ul>
            </div>
           </div>
        <%}%>
        <form action="ListLocation_Servlet" method="POST">
        <td><p hidden><input type="text" name="Redirect" value= "WeatherForecast_Servlet"></p></td>     
        <input type="submit" value="Change Location (LIST)" ></form>
                <br>            
        <form action="LocationMap_Servlet" method="POST">
        <td><p hidden><input type="text" name="Redirect" value= "WeatherForecast_Servlet"></p></td>     
        <input type="submit" value="Change Location (MAP)" ></form>

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
                <form name="submitForm" method="POST" action="CurrentWeather_Servlet">
                <input type="hidden" name="param1" value="param1Value">
                <a HREF="javascript:document.submitForm.submit()">CURRENT WEATHER</a></form>
                <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
                <a href="601_weather_history.jsp">WEATHER HISTORY</a>
                <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
            </div> 
            
        </div>
    </body>
</html>
