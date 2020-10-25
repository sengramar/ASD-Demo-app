<%-- 
    Document   : 203_AdminLogin
    Created on : 2020. 9. 21, 오후 7:45:45
    Author     : yses9
--%>


<%@page import="Model.Administrator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/newcss.css"/>
        <style>
        body {
            background-image: url("img/sub_bg.png");
            background-size: 100%;
            background-repeat: no-repeat;
        }
            .mainnav { height: 100%; width: 250px; position: fixed; top: -50px; left: 20px; font-family: Trebuchet MS; font-size: 30px; }
            .mainnav a { color: black; text-decoration: none; display: block;}
            .subnav p {display: inline-block;};
        </style>
    </head>
    
    
    <body>
    <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
    %>
    
    <a href="index.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>
  
          <a  HREF="javascript:document.CurrentWeather.submit()"><form class="nav_1" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet"><img src="img/nav_1.png" width="340"></form></a>
                
                
            <form  class="nav_2" name="WeatherHistory" method="POST" action="FirstWeatherHistory_Servlet">
                <a  HREF="javascript:document.WeatherHistory.submit()"><img src="img/nav_2.png" width="340"></a></form>
            
            <form class="nav_3" name="WeatherAnalysis" method="POST" action="WeatherAnalysis_Servlet">
                <a  HREF="javascript:document.WeatherAnalysis.submit()"><img src="img/nav_3.png" width="341"></a></form>
            
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_5" ></a>
   
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_7.png" class="nav_6" ></a>
            

        
            
            
    <center>     
        <img class="heading_img_1" src="img/login_heading.png"><br>
        
        <div class="regbox">
        <form method="post" name="form" action="AdminLogin_Servlet">
            <span><%=(existErr != null ? existErr : "")%></span><br>
        <table>
            <tr>
            <td><p class="subtitle"><label for="Email">Email</label></p></td>
                <td><p>&nbsp;</p></td>
                <td><p><input type="Email" name="Email"required="True" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>"></p></td>
            </tr>
            <tr>
            <td><p class="subtitle"><label for="Password">Password</label></p></td>
                <td><p>&nbsp;</p></td>
                <td><p><input type="Password" name="Password" required="True"  placeholder="<%=(passErr != null ? passErr : "Enter password")%>"></p></td>
            </tr>
        </table>
        <button class="btn" type="submit"> <img src="img/login_btn_black.png" width="150"> </button>
        <button class="btn"><a href="index.jsp"> <img src="img/cancel_btn.png" width="150"></a> </button><br><br>
        <div class="subnav">
            <p><a href="205_AdminFindPassword.jsp">Forgot your password?</a>
                &nbsp; &nbsp; &nbsp;
            <p><a href="102_register_admin.jsp"> Sign Up </a>
        </div>
        <p>if you want to login as User Click <a href="201_login.jsp"> Here </a>
        </form>
        </div>
   </center>
        
    </body>
</html>