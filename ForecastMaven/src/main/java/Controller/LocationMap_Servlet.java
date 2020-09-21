package Controller;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(name = "LocationMap_Servlet", urlPatterns = {"/LocationMap_Servlet"})
public class LocationMap_Servlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
            String Country = request.getParameter("Country");
            String Region = request.getParameter("Region");
            
            String Location = Region + ","+ Country;
            session.setAttribute("Location", Location);
            
            RequestDispatcher rd = request.getRequestDispatcher("CurrentWeather_Servlet");
            rd.forward(request, response);
        
       
        
        
    }
}
