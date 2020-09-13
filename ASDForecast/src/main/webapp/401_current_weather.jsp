<%-- 
    Document   : 401_current_weather
    Created on : 2020. 8. 25, 오전 11:18:05
    Author     : soyoung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Current Weather Page</title>
    </head>
   <body>
        <%       
        String Celcius = (String) session.getAttribute("Celcius");
        String Kelvin = (String) session.getAttribute("Kelvin");
        String Fahrenheit = (String) session.getAttribute("Fahrenheit");
        String City = (String) session.getAttribute("City");
        String Country = (String) session.getAttribute("Country");
        String Cloudy = (String) session.getAttribute("Cloudy");
        String Humidity = (String) session.getAttribute("Humidity");
        String WindDegree = (String) session.getAttribute("WindDegree");
        String WindSpeed = (String) session.getAttribute("WindSpeed");
        String Description = (String) session.getAttribute("Description");
        %>
        <div class="content">
            <br><br>
            <div class="header"> <h1>Current Weather</h1></div>
            <h2> Currently in <%=City %>, <%=Country%></h2>
            <h2> <%=Description.toUpperCase() %> </h2>
            <table>
            <td>
                <tr>
                   <h2> Current Temperature <%=Celcius%>°C || <%=Fahrenheit%>°F || <%=Kelvin%>K </h2>
                </tr>
            </td>
            <td>
                <tr>
                   <h2> Wind Speed <%=WindSpeed%> km/h at <%=WindDegree %>°</h2>
                </tr>
            </td>
            <td>
                <tr>
                   <h2> Humidity = <%=Humidity%>%</h2>
                </tr>
            </td>
            <td>
                <tr>
                   <h2> Clouds = <%=Cloudy%>%</h2>
                </tr>
            </td>
            
            </table>                 
        <form action="ListLocation_Servlet" method="POST">
        <td><p hidden><input type="text" name="Redirect" value= "CurrentWeather_Servlet"></p></td>     
        <input type="submit" value="Change Location" ></form>
        </form>
         <div class="sidenav">
            <br><br>
            <a href="index.html">HOME</a>
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
