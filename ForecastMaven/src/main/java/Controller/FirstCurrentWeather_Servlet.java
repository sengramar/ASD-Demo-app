package Controller;
import DAO.MongoDBManager;
import Model.User;
import Model.Location;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FirstCurrentWeather_Servlet", urlPatterns = {"/FirstCurrentWeather_Servlet"})
public class FirstCurrentWeather_Servlet extends HttpServlet 
{
    private MongoDBManager Query = new MongoDBManager();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String Country, Region;
        int LocationID;

        if(user == null)
        {
            Country = "AU";
            Region = "Sydney";
            LocationID = 101;
        }
        else 
        {
            LocationID = user.getLocationId();
            Location Current = Query.findLoc(LocationID);
            Country = Current.getCountry();
            Region = Current.getRegion();
        }

            String Location = Region + ","+ Country;
            session.setAttribute("Location", Location);
            session.setAttribute("LocationID", LocationID);
             
            RequestDispatcher rd = request.getRequestDispatcher("CurrentWeather_Servlet");
            rd.forward(request, response);
        }
    }