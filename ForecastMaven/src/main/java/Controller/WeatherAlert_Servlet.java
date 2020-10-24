/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import API.Mail;
import API.weatherAPI;
import API.weatherAlertMail;
import DAO.MongoDBManager;
import Model.Location;
import Model.User;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
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
             
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");   
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = (dateFormat.format(now));
        String time = (timeFormat.format(now));
        
        weatherAPI API = new weatherAPI();
        
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        User user = (User)session.getAttribute("user");
        
        String firstname = user.getFirstname();

        int LocationID;
        LocationID = user.getLocationId();
        Location Current = Mongo.findLoc(LocationID);
        String Country = Current.getCountry();
        String Region = Current.getRegion();
        String Location = Region + ","+ Country;
        
        String APIResult = API.request(Location);
        String City = "" + API.getCity(APIResult);
        String Celcius = Integer.toString(API.getCelcius(APIResult));
        String Fahrenheit = Integer.toString(API.getFahrenheit(APIResult));
        String Kelvin = Integer.toString(API.getKelvin(APIResult));
        
        String Cloudy = "" + API.getCloudy(APIResult);
        String Humidity = "" + API.getHumidity(APIResult);
        String WindDegree = API.getWindDeg(APIResult);
        String WindSpeed = API.getWindSpeed(APIResult);
        String Description = "" + API.getDescription(APIResult);
        String Icon = "" + API.getIcon(APIResult);
        
        LinkedList<User> ListUser = Mongo.findUserLoc(LocationID);

//        for (int i = 0 ; i < ListUser.size() ; i ++) 
//        { 
//            weatherAlertMail.SendMail(ListUser.get(i).getEmail(), "");
//        }
        
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
        session.setAttribute("Icon", Icon);
        
        if(Integer.parseInt(Celcius) > 40){
            session.setAttribute("warning", "The weather is hot and the sun is strong, so take sunscreen, hat, and sunglasses.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
            for (int i = 0 ; i < ListUser.size() ; i ++) 
            { 
                weatherAlertMail.SendMail(ListUser.get(i).getEmail(), "Hello, " +firstname+ "\n\n   The current weather issue in " +Region+ "\n   The weather is hot and the sun is strong, so take sunscreen, hat, and sunglasses. "
                        + "\n\n    If you want to know more detail weather information, please visit our website \n\n Thank you, \n\n Weather Now");
            }
        }
        if(Double.parseDouble(WindSpeed) > 10.8 && Double.parseDouble(WindSpeed) < 13.8) {
            session.setAttribute("windWarning", "The big branches shake, the wires shake, and the wind blows to the point where you can't hold an umbrella!");
            request.getRequestDispatcher("alert.jsp").include(request,response);
            for (int i = 0 ; i < ListUser.size() ; i ++) 
            { 
                weatherAlertMail.SendMail(ListUser.get(i).getEmail(), "Hello, " +firstname+ "\n\n   The current weather issue in " +Region+ "\n    The big branches shake, the wires shake, and the wind blows to the point where you can't hold an umbrella!"
                + "\n\n    If you want to know more detail weather information, please visit our website \n\nThank you, \n\nWeather Now");
            }
        }
        if (Description.equals("light rain")) {
            session.setAttribute("rainWarning", "It's drizzling.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
            for (int i = 0 ; i < ListUser.size() ; i ++) 
            { 
                weatherAlertMail.SendMail(ListUser.get(i).getEmail(), "Hello, " +firstname+ "\n\n   The current weather issue in " +Region+ "\n    It's drizzling."
                + "\n\n    If you want to know more detail weather information, please visit our website \n\nThank you, \n\nWeather Now");
            }
        }
        if (Description.equals("moderate rain")) {
            session.setAttribute("rainWarning", "It's raining moderately.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
            for (int i = 0 ; i < ListUser.size() ; i ++) 
            { 
                weatherAlertMail.SendMail(ListUser.get(i).getEmail(), "Hello, " +firstname+ "\n\n   The current weather issue in " +Region+ "\n    It's raining moderately."
                + "\n\n    If you want to know more detail weather information, please visit our website \n\nThank you, \n\nWeather Now");
            }
        }
        if (Description.equals("shower rain")) {
            session.setAttribute("rainWarning", "There may be a sudden shower, so take your umbrella.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
            for (int i = 0 ; i < ListUser.size() ; i ++) 
            { 
                weatherAlertMail.SendMail(ListUser.get(i).getEmail(), "Hello, " +firstname+ "\n\n   The current weather issue in " +Region+ "\n    There may be a sudden shower, so take your umbrella."
                + "\n\n    If you want to know more detail weather information, please visit our website \n\nThank you, \n\nWeather Now");
            }
        }
        if (Description.equals("heavy intensity rain") && Description.equals("very heavy rain")) {
            session.setAttribute("rainWarning", "It's raining hard. Be careful when you go out!");
            request.getRequestDispatcher("alert.jsp").include(request,response);
            for (int i = 0 ; i < ListUser.size() ; i ++) 
            { 
                weatherAlertMail.SendMail(ListUser.get(i).getEmail(), "Hello, " +firstname+ "\n\n   The current weather issue in " +Region+ "\n    It's raining hard. Be careful when you go out!"
                + "\n\n    If you want to know more detail weather information, please visit our website \n\nThank you, \n\nWeather Now");
            }
        }
        if (Description.equals("broken clouds")) {
            session.setAttribute("cloudWarning", "It's a cloudy day.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
        }
        if (Description.equals("overcast clouds")) {
            session.setAttribute("cloudWarning", "It's a cloudy day. Please take an umbrella with you in case it rains.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
            for (int i = 0 ; i < ListUser.size() ; i ++) 
            { 
                weatherAlertMail.SendMail(ListUser.get(i).getEmail(), "Hello, " +firstname+ "\n\n   The current weather issue in " +Region+ "\n    It's a cloudy day. Please take an umbrella with you in case it rains."
                + "\n\n    If you want to know more detail weather information, please visit our website \n\nThank you, \n\nWeather Now");
            }
        }
        if (Description.equals("tunderstorm")) {
            session.setAttribute("rainWarning", "There's thunder and lightning.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
            for (int i = 0 ; i < ListUser.size() ; i ++) 
            { 
                weatherAlertMail.SendMail(ListUser.get(i).getEmail(), "Hello, " +firstname+ "\n\n   The current weather issue in " +Region+ "\n    There's thunder and lightning."
                + "\n\n    If you want to know more detail weather information, please visit our website \n\nThank you, \n\nWeather Now");
            }
        }
        if (Description.equals("snow")) {
            session.setAttribute("snowWarning", "It's snowing, so watch out for icy roads.");
            request.getRequestDispatcher("alert.jsp").include(request,response);
            for (int i = 0 ; i < ListUser.size() ; i ++) 
            { 
                weatherAlertMail.SendMail(ListUser.get(i).getEmail(), "Hello, " +firstname+ "\n\n   The current weather issue in " +Region+ "\n    It's snowing, so watch out for icy roads."
                + "\n\n    If you want to know more detail weather information, please visit our website \n\nThank you, \n\nWeather Now");
            }
        }
        
        response.sendRedirect("alert.jsp");
     }
}
