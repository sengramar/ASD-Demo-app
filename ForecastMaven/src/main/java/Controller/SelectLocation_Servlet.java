package Controller;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "SelectLocation_Servlet", urlPatterns = {"/SelectLocation_Servlet"})
public class SelectLocation_Servlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String Redirect = (String) session.getAttribute("Redirect");
        
        
        if (Redirect.equals("101_register.jsp"))
        {        
        int LocationID = Integer.parseInt(request.getParameter("ID"));
        String State = request.getParameter("State");
        String Region = request.getParameter("Region");
        //this value will be only passed if it is redirect to 101_register.jsp
        //this code can be re-used
        session.setAttribute("State", State);
        session.setAttribute("LocationID", LocationID);
        session.setAttribute("Region", Region);

        response.sendRedirect(Redirect);//redirect to index.html page
        }
        else if (Redirect.equals("CurrentWeather_Servlet"))
        {
            String Country = request.getParameter("Country");
            String Region = request.getParameter("Region");
            int LocationID = Integer.parseInt(request.getParameter("ID"));
            
            String Location = Region + ","+ Country;
            session.setAttribute("Location", Location);
             session.setAttribute("LocationID", LocationID);
             
            RequestDispatcher rd = request.getRequestDispatcher("CurrentWeather_Servlet");
            rd.forward(request, response);
        }
       
        
        
    }
}