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
        <script type="text/javascript">
            function setCookie(name, value, expiredays) {
                var date = new Date();
                date.setDate(date.getDate() + expiredays);
                document.cookie = escape(name) + "=" + escape(value) + "; expires=" + date.toUTCString();
            }
            
            function closePopup() {
                if (document.getElementById("check").value) {
                    setCookie("popupYN", "N", 1);
                    self.close();
                }
            }
        </script>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
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
            String warning = (String) session.getAttribute("warning");
            String windWarning = (String) session.getAttribute("windWarning");
            String rainWarning = (String) session.getAttribute("rainWarning");
            String img = (String) session.getAttribute("img");
        %>
        
            <input type="hidden"  name="userId" required="true" value="${user.userId}">
            <tr>
                <td>Location:</td><td><input type="text"  name="location" required="true" readonly="true" value="${user.locationId}"></td>
            </tr>
            <h2> You are in <%=City %>, <%=Country%></h2>
            <h2><%=(warning != null ? warning : "")%></h2>
            <h2><%=(windWarning != null ? windWarning : "")%></h2>
            <h2><%=(rainWarning != null ? rainWarning : "")%></h2>
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
            </td>
            </table>
                
        <input type="checkbox" id="check" onclick="closePopup()">
        <font> <b>Don't see any more today</b> </font>
    </body>
</html>
