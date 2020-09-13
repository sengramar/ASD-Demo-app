<%-- 
    Document   : 101_check_admin
    Created on : 2020. 9. 8, 오후 1:24:07
    Author     : Nayoon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Check AdminKey</title>
    </head>
    <body>
<!--        <div class="sidenav">
            <br><br>
            <a href="index.html">Home</a>
        </div>-->
    <center>
        <div class="regbox">
        <%
            String adminKeyErr = (String) session.getAttribute("adminKeyErr");
        %>
        <h3>Please enter the specified administrator key value</h3>
        <form method="post">
        <table>
            <tr>
            <td><p class="subtitle"><label for="adminKeyErr">Admin Key</label></p></td>
                <td>&nbsp;</td>
            <td><p><input type="adminKey" name="adminKey" required="True" placeholder="<%=(adminKeyErr != null ? adminKeyErr : "Enter admin key")%>"></p></td>
            </tr>
        </table>
            <p><button type="submit" formaction="101_register_admin.jsp"><h2> SUBMIT <h2></button><p> </form>
        </div>
            <br><a>Go back to main menu</a>
            <a href="index.jsp"> click here!</a>
    </center>
    </body>
</html>
