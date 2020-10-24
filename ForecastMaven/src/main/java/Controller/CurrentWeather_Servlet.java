/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michael
 */

package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import API.weatherAPI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import DAO.*;


@WebServlet(name = "CurrentWeather_Servlet", urlPatterns = {"/CurrentWeather_Servlet"})
public class CurrentWeather_Servlet extends HttpServlet 
{
    private MongoDBManager Query;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");   
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = (dateFormat.format(now));
        String time = (timeFormat.format(now));
        
        
        weatherAPI API = new weatherAPI();
        
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        String Location;
            Location = (String) session.getAttribute("Location");
            int LocationId = (int) session.getAttribute("LocationID");
        
        String APIResult = API.request(Location);
        String City = "" + API.getCity(APIResult);
        String Country = "" + API.getCountry(APIResult);
        String Celcius = Integer.toString(API.getCelcius(APIResult));
        String Fahrenheit = Integer.toString(API.getFahrenheit(APIResult));
        String Kelvin = Integer.toString(API.getKelvin(APIResult));
        
        
        String Cloudy = "" + API.getCloudy(APIResult);
        String Humidity = "" + API.getHumidity(APIResult);
        String WindDegree = API.getWindDeg(APIResult);
        String WindSpeed = API.getWindSpeed(APIResult);
        String Description = "" + API.getDescription(APIResult);
        
        Query = new MongoDBManager();
        Query.saveToWeatherHistory(date,time,LocationId,Celcius,Humidity,WindSpeed,WindDegree,Cloudy,Description);//run query
        
        session.setAttribute("Location", Location);
        session.setAttribute("Celcius", Celcius);
        session.setAttribute("Fahrenheit", Fahrenheit);
        session.setAttribute("Kelvin", Kelvin);
        
        session.setAttribute("City", City);
        session.setAttribute("Country", Country);
        
        session.setAttribute("Cloudy", Cloudy);
        session.setAttribute("Humidity", Humidity);
        session.setAttribute("WindDegree", WindDegree);
        
        session.setAttribute("WindSpeed", WindSpeed);
        session.setAttribute("Description", Description);

        response.sendRedirect("401_current_weather.jsp");//redirect to index.html page
    }
}
