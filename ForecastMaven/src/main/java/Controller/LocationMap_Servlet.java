package Controller;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;




@WebServlet(name = "LocationMap_Servlet", urlPatterns = {"/LocationMap_Servlet"})
public class LocationMap_Servlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String Redirect = (String) request.getParameter("Redirect");
        
        session.setAttribute("Redirect", Redirect);
        response.sendRedirect("801_Map_Location.jsp");
      
    }
}
