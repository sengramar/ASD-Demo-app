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
        <link rel="stylesheet" href="css/newcss.css"/>
        <title>Delete Succeed</title>
        <style>
            body {
                background-image: url("img/sub_bg.png");
                background-size: 100%;
                background-repeat: no-repeat;
            }
        </style>
    </head>
    <body>
       
    <center>
        <img class="heading_img" src="img/heading_account_deleted.png">
        <div class="regbox"> You have logged out.<br>click <a href="index.jsp">here</a> to go to the home page.</div>
    </center>
            <% 
                session.invalidate();
            %>
            
</body>
</html>
