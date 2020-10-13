/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import API.weatherAPI;
import DAO.MongoDBManager;
import Model.User;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Nayoon
 */
@WebServlet(name = "WeatherAlert_Servlet", urlPatterns = {"/WeatherAlert_Servlet"})
public class WeatherAlert_Servlet extends HttpServlet {
    private MongoDBManager Mongo = new MongoDBManager();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException 
    {       
         
//        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session = request.getSession();
//        
//        int userId = Integer.parseInt(request.getParameter("userId"));
//        String Email = (String) request.getParameter("Email");
//        String Password = (String) request.getParameter("Password");
//        String Firstname = (String) request.getParameter("Firstname");
//        String Lastname = (String) request.getParameter("Lastname");
//        int LocationID = (Integer) Integer.parseInt(request.getParameter("LocationID"));
//        
//        User user = new User(userId, LocationID, Password, Email, Firstname, Lastname);
//        
//        String Country = request.getParameter("Country");
//        String Region = request.getParameter("Region");
//            
//        String Location = Region + ","+ Country;
//        session.setAttribute("Location", Location);
//        session.setAttribute("LocationID", LocationID);
//        
//        RequestDispatcher rd = request.getRequestDispatcher("CurrentWeather_Servlet");
//        rd.forward(request, response);
//        
//        response.sendRedirect("alert.jsp");
             
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");   
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = (dateFormat.format(now));
        String time = (timeFormat.format(now));
        
        weatherAPI API = new weatherAPI();
        
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        //User user = (User)session.getAttribute("user");
        String Location;
        //int userId = Integer.parseInt(request.getParameter("userId"));
        int LocationID = 0;
        if(session.getAttribute("userId") == null)
        {
            Location = "Sydney, AU";
            LocationID = 1;
        }
        else
        {
            Location = (String) session.getAttribute("Location");
            LocationID = (int) session.getAttribute("location");
        }
        
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
        
        Mongo.saveToWeatherHistory(date,time,LocationID,Celcius,Humidity,WindSpeed,WindDegree,Cloudy,Description);//run query
        
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
        
        if(Integer.parseInt(Celcius) > 10){
            session.setAttribute("warning", "The weather is hot and the sun is strong, so take sunscreen, hat, and sunglasses.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
        }
        if(Double.parseDouble(WindSpeed) > 10.8 && Double.parseDouble(WindSpeed) < 13.8) {
            session.setAttribute("windWarning", "The big branches shake, the wires shake, and the wind blows to the point where you can't hold an umbrella!");
            request.getRequestDispatcher("alert.jsp").include(request,response);
        }
        if (Description.equals("light rain")) {
            session.setAttribute("rainWarning", "It's drizzling.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
        }
        if (Description.equals("moderate rain")) {
            session.setAttribute("rainWarning", "It's raining moderately.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
        }
        if (Description.equals("shower rain")) {
            session.setAttribute("rainWarning", "There may be a sudden shower, so take your umbrella.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
        }
        if (Description.equals("heavy intensity rain") && Description.equals("very heavy rain")) {
            session.setAttribute("rainWarning", "It's raining hard. Be careful when you go out!");
            request.getRequestDispatcher("alert.jsp").include(request,response);
        }
        if (Description.equals("broken clouds")) {
            session.setAttribute("cloudWarning", "It's a cloudy day.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
        }
        if (Description.equals("overcast clouds")) {
            session.setAttribute("cloudWarning", "It's a cloudy day. Please take an umbrella with you in case it rains.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
        }
        response.sendRedirect("alert.jsp");
     }
}
