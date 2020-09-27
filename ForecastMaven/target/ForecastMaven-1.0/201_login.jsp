<%-- 
    Document   : 201_login
    Created on : 2020. 8. 29, 오후 11:55:42
    Author     : yses9
--%>

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Login</title>
    </head>
    <body>
    <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
    %>
    <center>     
        <h1 class="header">Sign Up</h1><span><%=(existErr != null ? existErr : "")%></span><br>
        <div class="regbox">
        <form method="post" name="form" action="LoginMongoServlet">
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
        <button type="submit"> Login </button>
        <button><a href="index.jsp"> Cancel</a> </button>
        <p>if you want to login as Admin Click <a href="203_AdminLogin.jsp"> Here </a>
        </form>
        </div>
   </center>

    </body>
</html>