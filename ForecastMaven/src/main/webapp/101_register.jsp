<%-- 
    Document   : 101_register
    Created on : Sep 2, 2020, 2:27:41 PM
    Author     : Nayoon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Register New Customer</title>
    </head>
    <body>
<%
        String Email = (String) session.getAttribute("Email");
        String Password = (String) session.getAttribute("Password");
        String Firstname = (String) session.getAttribute("Firstname");
        String Lastname = (String) session.getAttribute("Lastname");
        String State = (String) session.getAttribute("State");
        int LocationID = (Integer) session.getAttribute("LocationID");
        String existErr = (String) session.getAttribute("existErr");
%>
      <center>     
          <h1 class="header">Register</h1><span><%=(existErr != null ? existErr : "")%></span><br>
<div class="regbox">
        <form method="POST">
<table>
<tr>
<td><p class="subtitle"><label for="Email">Email </label></p></td>
    <td><p>&nbsp;</p></td>
    <td><p><input type="Email" name="Email"required="True" value="<%=(Email != null ? Email : "Enter Email")%>"></p></td>
</tr>
<tr>
<tr>
<td><p class="subtitle"><label for="Password">Password </label></p></td>
    <td><p>&nbsp;</p></td>
    <td><p><input type="Password" name="Password"required="True" value="<%=(Password != null ? Password : "Enter Password")%>"></p></td>
</tr>
<tr>
<tr>
<td><p class="subtitle"><label for="Firstname">First Name </label></p></td>
    <td><p>&nbsp;</p></td>
    <td><p><input type="Firstname" name="Firstname"required="True" value="<%=(Firstname != null ? Firstname : "Enter First Name")%>"></p></td>
</tr>
<tr>
	<td><p class="subtitle"><label for="Lastname">Last Name </label></p></td>
    <td>&nbsp;</td>
    <td><p><input type="Lastname" name="Lastname"required="True" value="<%=(Lastname != null ? Lastname : "Enter Last Name")%>"></p></td>
</tr>
<tr>
<td><p hidden><input type="LocationID" name="LocationID" Required ="True" value=<%= LocationID%>></p></td>
<td><p hidden><input type="text" name="Redirect" value= "101_register.jsp"></p></td>
</tr>
<tr>
    <td><p class="subtitle">Location</p></td>
    <td>&nbsp;</td> 
    <td><button type="submit" formaction="ListLocation_Servlet"> Select </td>               
</tr>
</table
<p><button type="submit" formaction="RegistrationMongo_Servlet" ><h2> Add <h2></button><p> </form>
</div>
   
                   
                    
    <br><a>Go back to main menu </a>
<a href="index.jsp"> click here!</a> 
    </center>
    </body>
</html>
