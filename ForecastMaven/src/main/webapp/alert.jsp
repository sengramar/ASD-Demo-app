<%-- 
    Document   : alert
    Created on : 2020. 10. 4., 오전 7:41:22
    Author     : Nayoon
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="Model.Location"%>
<%@page import="DAO.DBManager"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Weather Alert</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
            String City = (String) session.getAttribute("City");
            String Country = (String) session.getAttribute("Country");
            String Description = (String) session.getAttribute("Description");
            String warning = (String) session.getAttribute("warning");
            String windWarning = (String) session.getAttribute("windWarning");
            String rainWarning = (String) session.getAttribute("rainWarning");
            String cloudWarning = (String) session.getAttribute("cloudWarning");
            String snowWarning = (String) session.getAttribute("snowWarning");
            String Region = (String) session.getAttribute("Region");
            String Icon = (String) session.getAttribute("Icon");
        %>
        
        <div class="content">
            <input type="hidden"  name="userId" required="true" value="${user.userId}">
            <div class="header"><h2> Welcome, <%=user.firstname%></h2></div>
            <h2> You are in <%=City %>, <%=Country%> <img src= <%= Icon %>></h2>
            <h3><%=(warning != null ? warning : "")%></h3>
            <h3><%=(windWarning != null ? windWarning : "")%></h3>
            <h3><%=(rainWarning != null ? rainWarning : "")%></h3>
            <h3><%=(cloudWarning != null ? cloudWarning : "")%></h3>
            <h3><%=(snowWarning != null ? snowWarning : "")%></h3>
            <h3><%=Description.toUpperCase() %></h3>
        </div>
    </body>
</html>
