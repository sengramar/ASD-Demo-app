<!DOCTYPE html>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/newcss.css"/>
<style>
        body {
            background-size: 100%;
            background-image: url("img/main_bg.png");
            
            background-repeat: no-repeat;
        }
    </style>
<title>Index</title>
</head>
<body>
   
        <form action="IndexLoginServlet" method="POST">
            <button type="submit" class="login"><img src="img/login.png" width="110"></button>
        </form>   
       
    
        <form action="IndexRegister_Servlet" method="POST">
            <button type="submit" class="register"><img src="img/register.png" width="120">
            </button>
        </form>
        
        
         <form name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet">
    <a class="main_2_1" HREF="javascript:document.CurrentWeather.submit()"><img src="img/current_weather.png" width="160"></a></form>
    
   <form name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
    <a class="main_3_1" HREF="javascript:document.WeatherForecast.submit()">
    <img src="img/weather_forecast.png" width="155"></a></form>
    
    
    <a class="main_4_1" href="1111_WindSpeedMap.jsp"><img src="img/wind_speed_map.png" width="165"></a>    
       
    <a class="main_5_1" href="1112_PrecipitationMap.jsp"> <img src="img/precipitation_map.png" width="165" ></a>

    </body>
</html>
