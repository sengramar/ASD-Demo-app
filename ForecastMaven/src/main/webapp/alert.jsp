<%-- 
    Document   : alert
    Created on : 2020. 10. 4., 오전 7:41:22
    Author     : Nayoon
--%>

<%@page import="DAO.DBManager"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weather Alert</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
            String Location = (String) session.getAttribute("Location");
            String Celcius = (String) session.getAttribute("Celcius");
            String Kelvin = (String) session.getAttribute("Kelvin");
            String Fahrenheit = (String) session.getAttribute("Fahrenheit");
            String City = (String) session.getAttribute("City");
            String Country = (String) session.getAttribute("Country");
            String Cloudy = (String) session.getAttribute("Cloudy");
            String Humidity = (String) session.getAttribute("Humidity");
            String WindDegree = (String) session.getAttribute("WindDegree");
            String WindSpeed = (String) session.getAttribute("WindSpeed");
            String Description = (String) session.getAttribute("Description");
        %>
        
        <form method="post" action="WeatherAlert_Servlet">
            <tr>
                <td>Location:</td><td><input type="text"  name="location" required="true" readonly="true" value="${user.locationId}"></td>
            </tr>
<!--            <h2> Currently in <%=City %>, <%=Country%></h2>
            <h2> <%=Description.toUpperCase() %> </h2>
            <table>
            <td>
                <tr>
                   <h2> Current Temperature <%=Celcius%>°C || <%=Fahrenheit%>°F || <%=Kelvin%>K </h2>
                </tr>
            </td>
            <td>
                <tr>
                   <h2> Wind Speed <%=WindSpeed%> km/h at <%=WindDegree %>°</h2>
                </tr>
            </td>
            <td>
                <tr>
                   <h2> Humidity = <%=Humidity%>%</h2>
                </tr>
            </td>
            <td>
                <tr>
                   <h2> Clouds = <%=Cloudy%>%</h2>
                </tr>
            </td>-->
            
            </table>
        </form>
    </body>
</html>
