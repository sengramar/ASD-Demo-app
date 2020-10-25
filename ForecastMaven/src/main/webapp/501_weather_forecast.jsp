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
        <link rel="stylesheet" href="css/newcss.css"/>
        <title>Weather Forecast Page</title>
        <style>
            body {
                background-image: url("img/sub_bg.png");
                background-size: 100%;
                background-repeat: no-repeat;
            }
        
            ul {float:left;}
            ul li {list-style-type: none;}
            .topnav > div {float:right;}
            .selection > div {display:inline-block;}
        </style>
    </head>

    <body>
        <%

            String City = (String) session.getAttribute("City");
            String Country = (String) session.getAttribute("Country");
            User user = (User)session.getAttribute("user");
            Administrator admin = (Administrator)session.getAttribute("admin");
            
            
            if(admin!=null)
            {
            %>
            <a href="adminMain.jsp"><img src="img/main_btn_1.png" class="main_link" ></a>
            <div class="topnav">
                <form action="LogoutServlet" method="GET">
                <button type="submit" class="logout"><img src="img/logout_btn_white.png" width="90"></button>
                </form>  
                <a  class="account" href="308_account_management_admin.jsp"><img src="img/account_btn_white.png" width="185"></a>
            </div>
 
            <form class="nav_1" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet">
                <a HREF="javascript:document.CurrentWeather.submit()"><img src="img/nav_1.png" width="340"></a>
            </form>    

            <form  class="nav_2" name="WeatherHistory" method="POST" action="FirstWeatherHistory_Servlet">
                <a  HREF="javascript:document.WeatherHistory.submit()"><img src="img/nav_2.png" width="340"></a></form>
            
            <form class="nav_3" name="WeatherAnalysis" method="POST" action="WeatherAnalysis_Servlet">
                <a  HREF="javascript:document.WeatherAnalysis.submit()"><img src="img/nav_3.png" width="341"></a></form>
            
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>
            <%
            }
             else if(user==null)
             {
            %>
            
           <a href="index.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>
            <div class="topnav">   
                <a href="101_register.jsp"><img src="img/register_btn.png" width="120"></a>
                <a href="201_login.jsp"><img src="img/login_btn.png" width="120"></a>
            </div>
            
            <form class="nav_3" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet">
                <a  HREF="javascript:document.CurrentWeather.submit()">
                    <img src="img/nav_3_1.png" width="337"></a>
            </form>
                
              
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>
            
            <%
            }
            else
            {
            %>
            <a href="main.jsp"><img src="img/main_btn_1.png" class="main_link" ></a>
            <div class="topnav">
                <form action="LogoutServlet" method="GET">
                <button type="submit" class="logout"><img src="img/logout_btn_white.png" width="90"></button>
                </form>  
                <a  class="account" href="301_account_management.jsp"><img src="img/account_btn_white.png" width="185"></a>
            </div>
 
             <form class="nav_1" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet">
                <a  HREF="javascript:document.CurrentWeather.submit()">
                    <img src="img/nav_1.png" width="337"></a>
            </form>
                
            <form  class="nav_2" name="WeatherHistory" method="POST" action="FirstWeatherHistory_Servlet">
                <a  HREF="javascript:document.WeatherHistory.submit()"><img src="img/nav_2.png" width="340"></a></form>
            
            <form class="nav_3" name="WeatherAnalysis" method="POST" action="WeatherAnalysis_Servlet">
                <a  HREF="javascript:document.WeatherAnalysis.submit()"><img src="img/nav_3.png" width="341"></a></form>
            
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>
            
            <%
                }
            %>

                <center>  
        <div class="content">
            <img class="heading_img_2" src="img/heading_weather_forecast.png">
        <div class="regbox_1">
        <div class="selection">
            <div><h2><%=City %>, <%=Country%></h2></div>    
            &emsp;
            &emsp;
            <div><form action="ListLocation_Servlet" method="POST">
            <p hidden><input type="text" name="Redirect" value= "WeatherForecast_Servlet"></p>     
            <input type="submit" value="Change Location (LIST)" ></form>  </div>          
   
        </div>
        <%      
            LinkedList<WeatherForecast> forecast  = (LinkedList) session.getAttribute("forecast");
            for(int i =0; i<forecast.size(); i++){
        %> 
<!--            <form action="WeatherForecast_Servlet" method="POST">        -->
                    <ul>
                    <h3><%= forecast.get(i).getDate() %></h3>
                    <li>< Average ></li>
                    <li><B>TEMPERATURE</B> <%= forecast.get(i).getTemp() %>°C</li>
                    <li><B>HUMIDITY</B> <%= forecast.get(i).getHumidity() %>%</li>
                    <li><B>CLOUDINESS</B> <%= forecast.get(i).getCloudy() %>% </li>
                    <li><B>WIND SPEED</B> <%= forecast.get(i).getWindSpeed() %>m/s </li>
                    <li><B>WIND DEGREE</B> <%= forecast.get(i).getWindDegree() %> </li>
                    <li><%= forecast.get(i).getDescription().toUpperCase() %> <img src= <%= forecast.get(i).getIcon() %>></li>
                    </ul>
    
        <% } %>
       
        </div>
        </div></center>
                
    </body>
</html>
