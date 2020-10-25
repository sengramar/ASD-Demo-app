<%-- 
    Document   : 205_AdminFindPassword
    Created on : 2020. 10. 20, 오전 10:36:09
    Author     : yses9
--%>

<%@page import="Model.*"%>
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
        </style>
    </head>
    
    
    <body>
    <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String Firstname = (String) session.getAttribute("Firstname");
            String Lastname = (String) session.getAttribute("Lastname");
            String SentEmail = (String) session.getAttribute("SentEmail");
            String tempMsg = (String) session.getAttribute("tempMsg");
    %>
    <a href="index.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>
 
            <div class="topnav">   
                <a href="101_register.jsp"><img src="img/register_btn.png" width="120"></a>
                <a href="201_login.jsp"><img src="img/login_btn.png" width="120"></a>
            </div>
            
            <form class="nav_3" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet">
                <a HREF="javascript:document.CurrentWeather.submit()"><img src="img/nav_3_1.png" width="340"></a>
            </form>    
              
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>
            
    <center>     
        <img class="heading_img" src="img/heading_find_password.png">
        <div class="regbox">
        <form method="post" name="form" action="AdminFindPasswordServlet">
            <span><%=(existErr != null ? existErr : "")%></span><br>
            <p><span><%=(SentEmail != null? SentEmail : "")%></span></p>
        <table>
            <tr>
            <td><p class="subtitle"><label for="Email">Email</label></p></td>
                <td><p>&nbsp;</p></td>
                <td><p><input type="Email" name="Email"required="True" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>"></p></td>
            </tr>
            <tr>
            <td><p class="subtitle"><label for="Firstname">First Name </label></p></td>
                <td><p>&nbsp;</p></td>
                <td><p><input type="Firstname" name="Firstname"required="True" placeholder="<%=(Firstname != null ? Firstname : "Enter First Name")%>"></p></td>
            </tr>
            <tr>
            <td><p class="subtitle"><label for="Lastname">Last Name </label></p></td>
                <td>&nbsp;</td>
                <td><p><input type="Lastname" name="Lastname"required="True" placeholder="<%=(Lastname != null ? Lastname : "Enter Last Name")%>"></p></td>
            </tr>
        </table>
            
        <button type="submit"> Get Temporary Password </button>
        </form>
        <button><a href="index.jsp"> Cancel</a> </button>
        </div>
   </center>

    </body>
</html>