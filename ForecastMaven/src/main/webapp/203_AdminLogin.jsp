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
        <link rel="stylesheet" href="css/style.css"/>
        <title>Login</title>
        <style>
            .mainnav { height: 100%; width: 250px; position: fixed; top: -50px; left: 20px; font-family: Trebuchet MS; font-size: 30px; }
            .mainnav a { color: black; text-decoration: none; display: block;}
            .subnav >p {display: inline-block;};
        </style>
    </head>
    <body>
    <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
    %>
    <center>     
        <h1 class="header">Administrator Sign Up</h1><span><%=(existErr != null ? existErr : "")%></span><br>
        <div class="regbox">
        <form method="post" name="form" action="AdminLogin_Servlet">
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
        <div class="subnav">
            <p><a href="205_AdminFindPassword.jsp">Forgot your password?</a>
                &nbsp; &nbsp; &nbsp;
            <p><a href="102_register_admin.jsp"> Sign Up </a>
        </div>
        <p>if you want to login as User Click <a href="201_login.jsp"> Here </a>
        </form>
        </div>
   </center>
        <div class="mainnav">
            <br><br>
            <a href="index.jsp">HOME</a>
        </div> 
    </body>
</html>