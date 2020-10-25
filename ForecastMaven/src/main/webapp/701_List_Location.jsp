<%@page import="Model.Administrator"%>
<%@page import="Model.User"%>
<%@page import="java.util.LinkedList"%>

<%-- 
    Document   : save
    Created on : May 25, 2020, 1:27:37 PM
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/newcss.css"/>
<style>
            body {
                background-image: url("img/sub_bg.png");
                background-size: 100%;
                background-repeat: repeat;
            }
</style>


<title class="title">List Location</title>

</head>

    <Body>
        
        <% 
            User user = (User)session.getAttribute("user");
            Administrator admin = (Administrator)session.getAttribute("admin");
             if(admin!=null)
            {
            %>
            <a href="adminMain.jsp"><img src="img/main_btn_1.png" class="main_link" ></a>
            <div class="topnav">
                <form action="LogoutServlet" method="GET">
                <button type="submit" class="logout"><img src="img/logout_btn_white.png" width="90"></button>
                </form>  
                <a  class="account" href="308_account_management_admin.jsp"><img src="img/account_btn_white.png" width="185"></a>
            </div>
 
            <form class="nav_1" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet">
                <a HREF="javascript:document.CurrentWeather.submit()"><img src="img/nav_1.png" width="340"></a>
            </form>    

            <form  class="nav_2" name="WeatherHistory" method="POST" action="FirstWeatherHistory_Servlet">
                <a  HREF="javascript:document.WeatherHistory.submit()"><img src="img/nav_2.png" width="340"></a></form>
            
            <form class="nav_3" name="WeatherAnalysis" method="POST" action="WeatherAnalysis_Servlet">
                <a  HREF="javascript:document.WeatherAnalysis.submit()"><img src="img/nav_3.png" width="341"></a></form>
            
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>
            <%
            }
             else if(user==null)
             {
            %>
            
           <a href="index.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>
            <div class="topnav">   
                <a href="101_register.jsp"><img src="img/register_btn.png" width="120"></a>
                <a href="201_login.jsp"><img src="img/login_btn.png" width="120"></a>
            </div>
            
            <form class="nav_3" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet">
                <a  HREF="javascript:document.CurrentWeather.submit()">
                    <img src="img/nav_3_1.png" width="337"></a>
            </form>
                
              
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>
            
            <%
            }
            else{
            %>
            <a href="main.jsp"><img src="img/main_btn_1.png" class="main_link" ></a>
            <div class="topnav">
                <form action="LogoutServlet" method="GET">
                <button type="submit" class="logout"><img src="img/logout_btn_white.png" width="90"></button>
                </form>  
                <a  class="account" href="301_account_management.jsp"><img src="img/account_btn_white.png" width="185"></a>
            </div>
 
             <form class="nav_1" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet">
                <a  HREF="javascript:document.CurrentWeather.submit()">
                    <img src="img/nav_1.png" width="337"></a>
            </form>
                
            <form  class="nav_2" name="WeatherHistory" method="POST" action="FirstWeatherHistory_Servlet">
                <a  HREF="javascript:document.WeatherHistory.submit()"><img src="img/nav_2.png" width="340"></a></form>
            
            <form class="nav_3" name="WeatherAnalysis" method="POST" action="WeatherAnalysis_Servlet">
                <a  HREF="javascript:document.WeatherAnalysis.submit()"><img src="img/nav_3.png" width="341"></a></form>
            
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
            <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>
            
            <%}
            %>
     
        
                <center>    
                    <img class="heading_img_2" src="img/heading_location_list.png">
                    <div class="regbox_1">           
<table style="width: 70%" class="fl-table">
            
<form action="ListLocation_Search_Servlet" method="POST" >
<%-- 
Search Servlet
--%>
    
<p>Search : <input type="search" name="search" value="">
<p><button type="submit" class ="btn"> Search </button></p></form>
        <tr>
            <th class="subtitle">LocationID</th>
            <th class="subtitle">Country</th>
            <th class="subtitle">State</th>
            <th class="subtitle">Region</th>

        </tr> 
        <%         
        LinkedList List  = (LinkedList) session.getAttribute("List");
        for(int i =0; i < List.size(); i = i + 4)
        {
        %> 
          <tr>
          <form action="SelectLocation_Servlet" method="POST">
<%-- 
List Servlet
--%>
              
              <td>
                  <input class="subtitle" readonly="True" type="text" name="ID" value ="<%= List.get(i).toString().trim()  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="Country" value ="<%= List.get(i+1).toString().trim()  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="State" value ="<%= List.get(i+2).toString().trim()  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="Region" value ="<%= List.get(i+3).toString().trim()  %>">
              </td>            
             <td>
                  <input type="submit" value="Select" ></form>
             </td> 
        <%         
           }
        %> 
          </tr>
      </table>
          
        </div>  
</center>
    
    </body>
</html>
<script>
