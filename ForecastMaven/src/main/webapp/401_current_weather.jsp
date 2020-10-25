<%@page import="Model.Administrator"%>
<%@page import="Model.User"%>
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
        <link rel="stylesheet" href="css/newcss.css"/>
        <title>Current Weather Page</title>
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
        User user = (User)session.getAttribute("user");
        Administrator admin = (Administrator)session.getAttribute("admin");
        String Icon = (String) session.getAttribute("Icon");
        %>
         <% if(user == null)
            {
            %>
            <a href="index.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>
            <div class="topnav">   
                <a href="101_register.jsp"><img src="img/register_btn.png" width="120"></a>
                <a href="201_login.jsp"><img src="img/login_btn.png" width="120"></a>
            </div>
            
            <a  HREF="javascript:document.CurrentWeather.submit()"><form class="nav_3" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet"><img src="img/nav_3_1.png" width="337"></form></a>
                
              
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>
            
            <%
            }
            else{
            %>
            <a href="main.jsp"><img src="img/main_btn_1.png" class="main_link" ></a>
            <div class="topnav">
                <form action="LogoutServlet" method="GET">
                <button type="submit" class="logout"><img src="img/logout_btn_white.png" width="90"></button>
                </form>  
            </div>
 
            <a  HREF="javascript:document.CurrentWeather.submit()"><form class="nav_1" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet"><img src="img/nav_1.png" width="340"></form></a>
                
                
            <form  class="nav_2" name="WeatherHistory" method="POST" action="FirstWeatherHistory_Servlet">
                <a  HREF="javascript:document.WeatherHistory.submit()"><img src="img/nav_2.png" width="340"></a></form>
            
            <form class="nav_3" name="WeatherAnalysis" method="POST" action="WeatherAnalysis_Servlet">
                <a  HREF="javascript:document.WeatherAnalysis.submit()"><img src="img/nav_3.png" width="341"></a></form>
            
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>
            
            <%}
            %>
 
        
            <div class="content"><center>
            <br><br>
            <img class="heading_img" src="img/heading_current_weather.png">
            <div class="regbox">
            <h2> Currently in <%=City %>, <%=Country%></h2>
            <h2> <%=Description.toUpperCase() %> <img src= <%= Icon %>> </h2>
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
                <br>
        <form action="ListLocation_Servlet" method="POST">
        <input type="hidden" name="Redirect" value= "CurrentWeather_Servlet">     
        <input type="submit" value="Change Location (LIST)" ></form>
                <br>
        <button onclick="location.href = '801_Map_Location.jsp';" >Change Location (MAP)</button>  
        
            </div>
        
        </div>
            </center>

    </body>
</html>
