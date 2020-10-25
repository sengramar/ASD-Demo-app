package Controller;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import Model.Location;
import java.util.LinkedList;




@WebServlet(name = "WeatherHistory_Servlet", urlPatterns = {"/WeatherHistory_Servlet"})
public class WeatherHistory_Servlet extends HttpServlet 
{
    private MongoDBManager Query = new MongoDBManager();;
    private LinkedList list;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String searchRegion = "" + request.getParameter("Region");
        if(request.getParameter("Region").equals(""))
        {
            searchRegion = " ";
        }
        else
        {
            searchRegion = (String) request.getParameter("Region");
        }
        
        String SearchRegion = searchRegion.substring(0, 1).toUpperCase() + searchRegion.substring(1); 
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        System.out.println("REGION NAME"+  searchRegion);
        
        String result = "";
        String[] r = searchRegion.split("(?=\\p{Upper})");
        for(int i =0; i < r.length;i++)
        {
            result = result.trim() +" " + r[i];
        }
        
        System.out.print("Ryo made it no error"+result);
        
        Location current = Query.findLocationId(result);
       
        //list = Query.search_history(searchLocation);//run query*/
        list = Query.weather_history(Integer.toString(current.getLocationID()));
        session.setAttribute("ListHistory", list);//set attribute to be redirected
        
        response.sendRedirect("601_weather_history.jsp");//redirect to index.html page
    }
}
