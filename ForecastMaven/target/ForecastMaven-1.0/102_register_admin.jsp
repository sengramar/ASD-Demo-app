<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/newcss.css"/>
        <title>Register Administrator</title>
        <style>
        body {
            background-image: url("img/sub_bg.png");
            background-size: 100%;
            background-repeat: no-repeat;
        }
        </style>
        <%
        String Email = (String) session.getAttribute("Email");
        String Password = (String) session.getAttribute("Password");
        String Firstname = (String) session.getAttribute("Firstname");
        String Lastname = (String) session.getAttribute("Lastname");
        String existErr = (String) session.getAttribute("existErr");
        String error = (String) session.getAttribute("error");
        %>
    </head>
    <body>
        <a href="index.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>
            <div class="topnav">   
                <a href="201_login.jsp"><img src="img/login_btn.png" width="120"></a>
            </div>
            
            <a  HREF="javascript:document.CurrentWeather.submit()"><form class="nav_3" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet"><img src="img/nav_3_1.png" width="337"></form></a>
                
              
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>
            
<center>     
            <img class="heading_img_1" src="img/register_heading.png">
            
<div class="regbox">
<form method="POST">
            <span><%=(existErr != null ? existErr : "")%><br>
            <h3><%=(error != null ? error : "")%></h3></span><br>
<table>
<tr>
<td><p class="subtitle"><label for="Email">Email </label></p></td>
    <td><p>&nbsp;</p></td>
    <td><p><input type="Email" name="Email" required="True" value="<%=(Email != null ? Email : "Enter Email")%>"></p></td>
</tr>
<tr>
<tr>
<td><p class="subtitle"><label for="Password">Password </label></p></td>
    <td><p>&nbsp;</p></td>
    <td><p><input type="Password" name="Password"required="True" minlength="8" value="<%=(Password != null ? Password : "Enter Password")%>"></p></td>
</tr>
<tr>
    <tr>
        <td><p class="subtitle"><label for="Firstname">First Name </label></p></td>
        <td><p>&nbsp;</p></td>
        <td><p><input type="Firstname" name="Firstname"required="True" value="<%=(Firstname != null ? Firstname : "Enter First Name")%>"></p></td>
    </tr>
    <tr>
	<td><p class="subtitle"><label for="Lastname">Last Name </label></p></td>
        <td>&nbsp;</td>
        <td><p><input type="Lastname" name="Lastname" required="True" value="<%=(Lastname != null ? Lastname : "Enter Last Name")%>"></p></td>
    </tr>
    </table><br>
    
    <button class="btn" type="submit" formaction="RegistrationAdminMongo_Servlet"><img src="img/register_btn_black.png" width="120"> </button></p> 
</form>
    <button class="btn"><a href="index.jsp"> <img src="img/cancel_btn.png" width="130"></a></button>
       
    <form action="IndexRegister_Servlet" method="POST">
    <p>if you want to register as User Click <a href="101_register.jsp"> Here </a>
    </form>
</div>

    </center>
    </body>
</html>