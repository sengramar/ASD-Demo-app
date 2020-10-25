<%@page import="DAO.DBManager"%>
<%@page import="Model.Administrator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/newcss.css"/>
        <title>Account Management</title>
        <style>
            body {
                background-image: url("img/sub_bg.png");
                backgrouㅊnd-size: 100%;
                background-repeat: no-repeat;
            }
        </style>
    </head>
    <body>
        <%
            Administrator admin = (Administrator)session.getAttribute("admin");
            String updated = (String)session.getAttribute("updated");
            String errorMsg = (String)session.getAttribute("errorMsg");
            DBManager manager = (DBManager) session.getAttribute("manager");
       if(admin == null)
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
            <a href="adminmain.jsp"><img src="img/main_btn_1.png" class="main_link" ></a>
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
 
        
       
                <center> 
                    <div class="content"><br><br>
                        <img class="heading_img" src="img/heading_account_management.png"><br>
            <p><span><%=(errorMsg != null? errorMsg : "")%></span></p><span><%=(updated != null? updated : "")%></span>
           <div class="regbox"><br><br>
        <form method="post" action="EditAccountAdmin">
            <table>
                <input type="hidden"  name="userId" required="true" value="${admin.adminId}">
                <tr><td>First Name:</td><td><input type="text"  name="firstname" required="true" value="${admin.firstname}"></td></tr>
                <tr><td>Last Name:</td><td><input type="text"  name="lastname" required="true" value="${admin.lastname}"></td></tr>
                <tr><td>Email:</td><td><input type="text"  name="email" required="true" value="${admin.email}"></td></tr>
                <tr><td>Password:</td><td><input type="password"  name="password" required="true" value="${admin.adminPassword}"></td></tr>
                </td></tr>
                <tr><td></td><td><input class="in_btn" type="submit" value="Update"></td></tr>
            </table>
        </form><br>
        <td><form action="DeleteAccountAdmin_Servlet" method="POST">
            <table>
                <tr><td><input type="hidden"  name="userId" required="true" value="${admin.adminId}"></td></tr><tr><td></td></tr>
                <tr><td><input type="hidden"  name="email" required="true" value="${admin.email}"></td></tr>
                <tr><td><input type="hidden"  name="password" required="true" value="${admin.adminPassword}"></td></tr>
                <tr><td><button type="submit" class="button">Delete Account</button></td></tr></table>
            
            </form></td></tr>  
           
        </div><br>
                  
       </center> </div> 
        
    </body>
</html>