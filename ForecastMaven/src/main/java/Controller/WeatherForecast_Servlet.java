/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import API.dailyWeatherAPI;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.*;
import Model.WeatherForecast;
import java.util.LinkedList;


/**
 *
 * @author yses9
 */

@WebServlet(name = "WeatherForecast_Servlet", urlPatterns = {"/WeatherForecast_Servlet"})
public class WeatherForecast_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dailyWeatherAPI forecastAPI = new dailyWeatherAPI();
        HttpSession session = request.getSession();
        
        response.setContentType("text/html;charset=UTF-8");
        String Location;
        
        Location = (String) session.getAttribute("Location");
        int LocationId = (int) session.getAttribute("LocationID");
        
        LinkedList<WeatherForecast> forecast = new LinkedList<WeatherForecast>();
        System.out.println("test1");
        
        String Response= forecastAPI.request(Location);
        String[] Result = forecastAPI.Split(Response);

        String City = "" + forecastAPI.getCity(Response);
        String Country = "" + forecastAPI.getCountry(Response);
        
        for (int i = 1; i< Result.length; i++)
        {
            WeatherForecast current = new WeatherForecast
            (forecastAPI.getDate(Result[i]),
            forecastAPI.getTemp(Result[i]),
            forecastAPI.getCloudy(Result[i]),
            forecastAPI.getHumidity(Result[i]),
            forecastAPI.getWindSpeed(Result[i]),
            forecastAPI.getWindDeg(Result[i]),        
            forecastAPI.getDescription(Result[i]));
            forecast.add(current);
            
            System.out.println(forecastAPI.getTemp(Result[i]));
            System.out.println("test2");
        }
        System.out.println("test3");
        session.setAttribute("forecast", forecast);
        session.setAttribute("City", City);
        session.setAttribute("Country", Country);

         System.out.println("test4");
        response.sendRedirect("501_weather_forecast.jsp");
    }
}
