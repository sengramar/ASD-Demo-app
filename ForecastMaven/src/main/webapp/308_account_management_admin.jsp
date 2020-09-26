<%-- 
    Document   : 301_account_management
    Created on : 2020. 9. 13, 오후 6:23:32
    Author     : soyoung
--%>
<%@page import="DAO.DBManager"%>
<%@page import="Model.Administrator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Edit Page</title>
    </head>
    <body>
        <%
            Administrator admin = (Administrator)session.getAttribute("admin");
            String updated = (String)session.getAttribute("updated");
            DBManager manager = (DBManager) session.getAttribute("manager");
        %>
       <div class="sidenav">
            <br><br>
            <a href="adminMain.jsp">HOME</a>
            <form name="submitForm" method="POST" action="CurrentWeather_Servlet">
            <input type="hidden" name="param1" value="param1Value">
            <a HREF="javascript:document.submitForm.submit()">CURRENT WEATHER</a></form>
            <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
            <a href="601_weather_history.jsp">WEATHER HISTORY</a>
            <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
            <a href="308_account_management_admin.jsp">ACCOUNT MANAGEMENT</a>
        </div>
                <center> 
                    <div class="content"><br><br>
           <div class="header"> <h1>Edit Administrator Account<span><%=(updated != null? updated : "")%></span></h1></div><br>
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
                    <a href="adminMain.jsp" >Main page</a> 
       </center> </div> 
        
    </body>
</html>