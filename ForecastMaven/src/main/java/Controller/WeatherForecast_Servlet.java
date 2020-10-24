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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;
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
        
        LinkedList<WeatherForecast> dailyforecast = new LinkedList<WeatherForecast>();

        String Response= forecastAPI.request(Location);
        String[] Result = forecastAPI.Split(Response);

        String City = "" + forecastAPI.getCity(Response);
        String Country = "" + forecastAPI.getCountry(Response);
        
        String Desc = forecastAPI.getDescription(Result[0]);
        String Ico = forecastAPI.getIcon(Result[0]);
 
        String [] DateAndTime = forecastAPI.getDate(Result[0]).split(" ");
        String Date = DateAndTime[0]; 

        int Temp =0;
        int Cloud=0;
        int Hum=0;
        double WS=0;
        int WD =0;
        int count = 1;
        for (int i = 1; i< Result.length; i++)
        {
            if (Date.equals(forecastAPI.getDate(Result[i]).split(" ")[0]))
            {
                Temp = Temp + Integer.parseInt(forecastAPI.getTemp(Result[i]));
                Cloud = Cloud + Integer.parseInt(forecastAPI.getCloudy(Result[i]));
                Hum = Hum + Integer.parseInt(forecastAPI.getHumidity(Result[i]));
                WS = WS + Double.parseDouble(forecastAPI.getWindSpeed(Result[i]));
                WD = WD + Integer.parseInt(forecastAPI.getWindDeg(Result[i]));
                count ++;
            }
            
            else if (!Date.equals(forecastAPI.getDate(Result[i]).split(" ")[0]))
            {
                WeatherForecast current = new WeatherForecast(Date, ""+(Temp/count),""+(Cloud/count),""+(Hum/count),""+(int) Math. round(WS/count), ""+(WD/count),Desc,Ico);
                dailyforecast.add(current);

                DateAndTime = forecastAPI.getDate(Result[i]).split(" ");
                Date = DateAndTime[0]; 
                Desc = forecastAPI.getDescription(Result[i]);
                Ico = forecastAPI.getIcon(Result[i]);

                Temp = Integer.parseInt(forecastAPI.getTemp(Result[i]));
                Cloud =  Integer.parseInt(forecastAPI.getCloudy(Result[i]));
                Hum = Integer.parseInt(forecastAPI.getHumidity(Result[i]));
                WS = WS + Double.parseDouble(forecastAPI.getWindSpeed(Result[i]));
                WD = Integer.parseInt(forecastAPI.getWindDeg(Result[i]));
                count = 1;
            } 
            
            else if (i == Result.length)
            {
                WeatherForecast current = new WeatherForecast(Date, ""+(Temp/count),""+(Cloud/count),""+(Hum/count),""+(int) Math. round(WS/count), ""+(WD/count),Desc,Ico);
                dailyforecast.add(current);
            }
        }
        
        dailyforecast.removeFirst();

        session.setAttribute("forecast", dailyforecast);
        session.setAttribute("City", City);
        session.setAttribute("Country", Country);
        

        response.sendRedirect("501_weather_forecast.jsp");
    }
}
