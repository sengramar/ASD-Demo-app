<%-- 
    Document   : 901_weather_analysis
    Created on : 2020. 8. 25, 오전 11:18:44
    Author     : youjiwon
--%>

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
    <link rel="stylesheet" href="css/style.css"/>
    <style>
        section
        {
            height:400px;
            padding: 5px;
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
                text: region+ " "+ elements
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
     
    
   <div class="content">
   <br><br>
   <div class="header"> <h1>Weather Analysis</h1></div>
   <input type="hidden" required="false" id="elements" value=<%= elements %>>
   <input type="hidden" required="false" id="Region" value=<%= region %>>
   
   <form method="Post" action="WeatherAnalysis_Servlet">
    <select name="weatheranalysis">
        <option selected="selected"><%=elements%></option>
        <option value="temperature">temperature</option>
        <option value="humidity">humidity</option>
        <option value="cloudiness">cloudiness</option>
    </select>
    <input type="submit" value="Submit">
    </form>
   
    <form action="ListLocation_Servlet" method="POST">
    <input type="hidden" name="Redirect" value= "WeatherAnalysis_Servlet">    
    <input type="submit" value="Change Location (LIST)" >
    </form>
   
   
    <div id="chartContainer" style="height: 370px; width: 100%;"></div>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    
   
 
  
    <div class="sidenav">
            <br><br>
            <a href="index.html">HOME</a>
            <form name="submitForm" method="POST" action="FirstCurrentWeather_Servlet">
            <a HREF="javascript:document.submitForm.submit()">CURRENT WEATHER</a></form>
            <a href="501_weather_forecast.jsp">WEATHER FORECAST</a>
            <a href="601_weather_history.jsp">WEATHER HISTORY</a>
            <a href="901_weather_analysis.jsp">WEATHER ANALYSIS</a>
    </div>
    </div>
</body>
</html>  

