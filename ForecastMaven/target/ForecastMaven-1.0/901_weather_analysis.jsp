<%-- 
    Document   : 901_weather_analysis
    Created on : 2020. 8. 25, 오전 11:18:44
    Author     : youjiwon
--%>

<%@page import="Model.Administrator"%>
<%@page import="Model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Model.WeatherHistory"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
LinkedList<WeatherHistory> wa_list = (LinkedList)session.getAttribute("wa_list");
String elements = (String) session.getAttribute("elements");
String region = (String) session.getAttribute("Region");
region = region.replaceAll("\\s+","");

for(int i=0; i<wa_list.size(); i++)
{
    WeatherHistory wh = wa_list.get(i);
    SimpleDateFormat formatter =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String datetime = wh.getDate()+" "+wh.getTime();
    Date date = formatter.parse(datetime);
    int e;
        if(elements.equals("humidity"))
        {
            e = Integer.parseInt(wh.getHumidity());
        }
        
        else if(elements.equals("cloudiness"))
        {
            e = Integer.parseInt(wh.getCloudy());
        }
        
        else
        {
            e = Integer.parseInt(wh.getTemperature());
        }
    
        map = new HashMap<Object,Object>(); map.put("label",date); map.put("y",e); list.add(map);
   
}

String dataPoints = gsonObj.toJson(list);
        %>
%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="css/newcss.css"/>
    <style>
        section
        {
            height:400px;
            padding: 5px;
        }
        
        body {
                background-image: url("img/sub_bg.png");
                background-size: 100%;
                background-repeat: no-repeat;
        }
        
    </style>
<title>Weather Analysis Page</title>
<script type="text/javascript">
window.onload = function() 
{ 
var elements = document.getElementById("elements").value;
var region = document.getElementById("Region").value;

var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	exportEnabled: true,
	title: {
                text: region + " "+ elements
	},
	axisY:{
		includeZero: true
                
	},
	data: [{
		type: "line", //change type to bar, line, area, pie, etc
		//indexLabel: "{y}", //Shows y value on all Data Points
		indexLabelFontColor: "#5A5757",
		indexLabelPlacement: "outside",
                dataPoints: <%out.print(dataPoints);%>
	}]
     }); 
chart.render();
}
</script>
</head>
<body>
      <%       
        User user = (User)session.getAttribute("user");
        Administrator admin = (Administrator)session.getAttribute("admin");
       
         if(user == null || admin == null)
            {
            %>
            <a href="index.jsp"> <img src="img/main_btn_1.png" class="main_link" ></a>
            <div class="topnav">   
                <a href="101_register.jsp"><img src="img/register_btn.png" width="120"></a>
                <a href="201_login.jsp"><img src="img/login_btn.png" width="120"></a>
            </div>
            
            <a  HREF="javascript:document.CurrentWeather.submit()"><form class="nav_3" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet"><img src="img/nav_3_1.png" width="337"></form></a>
                
              
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
            </div>
 
            <a  HREF="javascript:document.CurrentWeather.submit()"><form class="nav_1" name="CurrentWeather" method="POST" action="FirstCurrentWeather_Servlet"><img src="img/nav_1.png" width="340"></form></a>
                
                
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
   <img class="heading_img_2" src="img/heading_weather_analysis.png">
   <div class="regbox_1">
   <input type="hidden" required="false" id="elements" value=<%= elements %>>
   
   
   <form class="regbox_2" method="Post" action="WeatherAnalysis_Servlet">
   <input type="hidden" required="false" name="Region" id="Region" value=<%= region %>>
    <select name="weatheranalysis">
        <option selected="selected"><%=elements%></option>
        <option value="temperature">temperature</option>
        <option value="humidity">humidity</option>
        <option value="cloudiness">cloudiness</option>
    </select>
    <input type="submit" value="Submit">
    </form>
   
   <form class="regbox_3" action="ListLocation_Servlet" method="POST">
        <input type="hidden" name="Redirect" value= "WeatherAnalysis_Servlet">    
        <input type="submit" value="Change Location (LIST)" >
   </form>
   
    <div id="chartContainer" style="height: 370px; width: 100%;"></div>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    
   
 
   </div>
    
    </cwnter>
</body>
</html>  

