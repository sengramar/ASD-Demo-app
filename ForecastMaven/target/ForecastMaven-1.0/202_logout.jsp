<%-- 
    Document   : 202_logout
    Created on : 2020. 9. 8, 오후 2:28:49
    Author     : yses9
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
        <title>Logout Page</title>
    </head>
    <body>
        <h3>
            You have logged out click <a href="index.jsp">here</a> to go to the home page.
        </h3>
            <% 
                session.invalidate();
            %>
    </body>
</html>
