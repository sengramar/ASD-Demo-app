<%-- 
    Document   : 601_weather_history
    Created on : 2020. 8. 25, 오전 11:18:31
    Author     : soyoung
--%>

<%@page import="Model.Administrator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="DAO.DBManager"%>
<%@page import="Model.User"%>
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


<title class="title">Weather History</title>

    </head>

    <Body>
        
        <% 
            User user = (User)session.getAttribute("user");
            Administrator admin = (Administrator)session.getAttribute("admin");
            if(user == null)
            {
            %>
            <a href="index.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>
            <%
            }
            else{
            %>
            <a href="main.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>
            <%}
            %>
            

            
              <a  HREF="javascript:document.CurrentWeather.submit()"><form class="nav_1" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet"><img src="img/nav_1.png" width="340"></form></a>
                
                
            <form  class="nav_2" name="WeatherHistory" method="POST" action="FirstWeatherHistory_Servlet">
                <a  HREF="javascript:document.WeatherHistory.submit()"><img src="img/nav_2.png" width="340"></a></form>
            
            <form class="nav_3" name="WeatherAnalysis" method="POST" action="WeatherAnalysis_Servlet">
                <a  HREF="javascript:document.WeatherAnalysis.submit()"><img src="img/nav_3.png" width="341"></a></form>
            
            <form class="nav_4" name="WeatherForecast" method="POST" action="FirstWeatherForecast_Servlet">
                <a  HREF="javascript:document.WeatherForecast.submit()"><img src="img/nav_4.png" width="340"></a></form>
             
           <a href="1111_WindSpeedMap.jsp"> <img src="img/nav_5.png" class="nav_5" ></a>
            
            <a href="1112_PrecipitationMap.jsp"> <img src="img/nav_6.png" class="nav_6" ></a>

        
            <img class="heading_img" src="img/heading_weather_history.png">
            
            <div class="regbox_1">
            <table style="width: 70%" class="fl-table">
            

<%-- 
Search Servlet
--%>
<%       
        String Region = (String) session.getAttribute("Region");
        Region = Region.replaceAll("\\s+", "");
%>
<form method="POST" >    
<p class="subtitle">Region</p>
<p hidden><input type="text" name="Redirect" value="601_weather_history.jsp"></p>
<p><input type="text" id="Region" name="Region" Required ="True" readonly="True" value=<%=(Region != null ? Region : "Select")%>>
<button type="submit" formaction="ListLocation_Servlet"> Select  </button>
<p hidden><input type="text" name="Redirect" value="601_weather_history.jsp"></p>
<p>&nbsp;</p>
<button onclick="clear()">Clear Text</button></form>
<p></p>
<form id="SubmitFormAll" method ="POST" action="FirstWeatherHistory_Servlet">
   
</form>
<form id="SubmitForm" method ="POST" action="WeatherHistory_Servlet">
<p hidden><input type="text" id="Region" name="Region" value=<%=(Region != null ? Region : "Select Your Location")%>><P>
</form>
<input type="button" onclick="SubmitSearch()" value="Search">

        <tr>
            <th class="subtitle">Region</th>
            <th class="subtitle">Date</th>
            <th class="subtitle">Time</th>
            <th class="subtitle">Temperature</th>
            <th class="subtitle">Humidity</th>
            <th class="subtitle">Wind Speed</th>
            <th class="subtitle">Wind Direction</th>
            <th class="subtitle">Cloudiness</th>
            <th class="subtitle">Description</th>
        </tr> 
        
        <%       
        //User user = (User)session.getAttribute("user");
        LinkedList List  = (LinkedList) session.getAttribute("ListHistory");
        for(int i =0; i < List.size(); i = i + 9)
        {
        %> 
          <tr>
<%-- 
List Servlet
--%>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="Region" style="width:100px" value ="<%= List.get(i).toString().trim()  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="Date" style="width:110px" value ="<%= List.get(i+1).toString().trim()  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="Time" style="width:90px" value ="<%= List.get(i+2).toString().trim()  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="Temperature" style="width:100px" value ="<%= List.get(i+3).toString().trim()  %> ℃">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="Humidity" style="width:80px" value ="<%= List.get(i+4).toString().trim()  %> %">
              </td>  
              <td>
                  <input class="subtitle" readonly="True" type="text" name="Wind speed" style="width:110px" value ="<%= List.get(i+5).toString().trim()  %> km/h">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="Wind direction" style="width:120px" value ="<%= List.get(i+6).toString().trim()  %>">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="Cloudy" style="width:90px" value ="<%= List.get(i+7).toString().trim()  %> %">
              </td>
              <td>
                  <input class="subtitle" readonly="True" type="text" name="danger level" style="width:120px" value ="<%= List.get(i+8).toString().trim()  %>">
              </td>  
        <%         
           }
        %> 
          </tr>
      </table>
          
<% if(user == null)
{%>
<form action="index.jsp" method="POST">
<%}
else{%>
<form action="main.jsp" method="POST">
<%}
%>
<p><button type="submit" class ="btn"> Back </button><p>
</form>
   
            </div>
    </body>
<script>
function clear() {
  <%       
        session.setAttribute("Region", "ALL");
  %>
}
function SubmitSearch() {
      if (document.getElementById("Region").value === "Select") 
      {
           alert("Select a location please");
      }
      else if (document.getElementById("Region").value === "ALL") 
      {
          document.getElementById("SubmitFormAll").submit();
      }
      else
      {
          document.getElementById("SubmitForm").submit();
      }
          
}
</script>    
</html>
