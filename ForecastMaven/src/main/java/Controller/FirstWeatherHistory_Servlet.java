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
import java.util.LinkedList;




@WebServlet(name = "FirstWeatherHistory_Servlet", urlPatterns = {"/FirstWeatherHistory_Servlet"})
public class FirstWeatherHistory_Servlet extends HttpServlet 
{
    private MongoDBManager Query = new MongoDBManager();;
    private LinkedList list;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        //int searchLocation = Integer.parseInt(request.getParameter("search"));
        

        
        
        //list = Query.search_history(searchLocation);//run query*/
        list = Query.weather_history("");
        session.setAttribute("ListHistory", list);//set attribute to be redirected
        
        response.sendRedirect("601_weather_history.jsp");//redirect to index.html page
    }
}
