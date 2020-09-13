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
        <link rel="stylesheet" href="css/style.css"/>


<title class="title">List Product</title>

    </head>

    <Body>
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
          
<form action="index.html" method="POST">
<p><button type="submit" class ="btn"> Back </button><p>
</form>
   
    
    </body>
</html>
<script>
