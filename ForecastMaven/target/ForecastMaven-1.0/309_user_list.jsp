<%-- 
    Document   : 309_user_list
    Created on : 2020. 9. 18, 오후 3:02:25
    Author     : soyoung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DBManager"%>
<%@page import="Model.User"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USER LIST Page</title>
    </head>
    <body>
        
        <%
            
            DBManager manager = (DBManager) session.getAttribute("manager");
            User user = (User) session.getAttribute("user");
            ArrayList<User> users = manager.listUsers();
        %>
        
         <table align="center">
                <tr>
                    <th>User ID</th>
                    <th>Location ID</th>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th> </th>
                </tr>
                <% for (User curr : users) {%>
                <tr>
                    <td><%=curr.getUserId()%></td>
                    <td><%=curr.getLocationId()%></td>
                    <td><%=curr.getEmail()%></td>
                    <td><%=curr.getFirstname()%></td>
                    <td><%=curr.getLastname()%></td>
                </tr>
                <% }%>
            </table>
            <a href="main.jsp">Main Page</a>
    </body>
</html>
