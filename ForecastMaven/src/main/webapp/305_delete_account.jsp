<%@page import="Model.User"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Delete Account Page</title>
</head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
            String update = (String)session.getAttribute("update");
        %>
       <div class="sidenav">
            <br><br>
            <a href="/Prototype">HOME</a>
            <form name="submitForm" method="POST" action="CurrentWeather_Servlet">
            <input type="hidden" name="param1" value="param1Value">
            <a HREF="javascript:document.submitForm.submit()">CURRENT WEATHER</a></form>
            <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
            <a href="601_weather_history.jsp">WEATHER HISTORY</a>
            <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
            <a href="301_account_management.jsp">ACCOUNT MANAGEMENT</a>
        </div>

       <div class="header"> <h1 align="center">Delete User Account : <span><%=(update != null? update : "")%></span></h1></div><br>

        <center> 
                    <div class="content"><br><br>
                        
        <form method="post" action="DeleteUser_Servlet">
            <table>
     
                <tr><td>Email:</td><td><input type="text"  name="email" required="true" value="${user.email}"></td></tr>
                <tr><td>Password:</td><td><input type="password"  name="password" required="true" value="${user.user_password}"></td></tr>
                    </td></tr>
                <tr><td></td><td><input type="submit" value="Delete"></td></tr>
            </table>
        </form>
                    <a href="main.jsp" class="search-btn">Main page</a>  
                    </div></center>
    </body>
</html>