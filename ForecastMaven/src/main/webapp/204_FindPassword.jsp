<%-- 
    Document   : 204_FindPassword
    Created on : 2020. 10. 2, 오후 6:53:00
    Author     : yses9
--%>

<%@page import="Model.*"%>
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
            String Firstname = (String) session.getAttribute("Firstname");
            String Lastname = (String) session.getAttribute("Lastname");
            String SentEmail = (String) session.getAttribute("SentEmail");
            String tempMsg = (String) session.getAttribute("tempMsg");
    %>
    <center>     
        <h1 class="header">Find Password</h1><span><%=(existErr != null ? existErr : "")%></span><br>
        <div class="regbox">
        <form method="post" name="form" action="FindPasswordServlet">
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
            
        <button type="submit"> Get Temperary Password </button>
        <button><a href="index.jsp"> Cancel</a> </button>
        </form>
        </div>
   </center>

    </body>
</html>