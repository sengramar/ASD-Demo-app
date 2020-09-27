<%-- 
    Document   : 304_delete_account
    Created on : 2020. 9. 23, 오후 4:16:39
    Author     : hazel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Delete Succeed</title>
    </head>
    <body>
        <h1 class="header">
            You have logged out
        </h1>
    <center>
        <h2> click <a href="index.jsp">here</a> to go to the home page.</h2>
    </center>
            <% 
                session.invalidate();
            %>
            
</body>
</html>
