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


@WebServlet(name = "WindSpeed_Servlet", urlPatterns = {"/WindSpeed_Servlet"})
public class WindSpeed_Servlet extends HttpServlet 
{
    //set DBConnector and Manager as private attribute so I can call anytime and close it when finish executing query
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        weatherAPI API = new weatherAPI();
        
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        String Email, Location;
        if(session.getAttribute("Location") == null)
        {
            Location = "Sydney, AU";
        }
        else
        {
            Location = (String) session.getAttribute("Location");
        }
        if(session.getAttribute("Email") == null)
        {
            Email = "";
        }
        else
        {
            Email = (String) session.getAttribute("Email");
        }
        
        System.out.println(Location);
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

        response.sendRedirect("1111_WindSpeedMap.jsp");//redirect to index.html page
    }
}
