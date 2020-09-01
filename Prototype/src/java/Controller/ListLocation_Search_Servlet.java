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




@WebServlet(name = "ListLocation_Search_Servlet", urlPatterns = {"/ListLocation_Search_Servlet"})
public class ListLocation_Search_Servlet extends HttpServlet 
{
    private DBConnector Connector;
    private DBManager Query;
    private LinkedList list;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String Redirect = (String) request.getParameter("Redirect");
        
        if (Redirect.equals("101_register.jsp"))
        {
        String Email = (String) request.getParameter("Email");
        String Password = (String) request.getParameter("Password");
        String Firstname = (String) request.getParameter("Firstname");
        String Lastname = (String) request.getParameter("Lastname");
        //this string needed so when they go back to register.jsp
        //they still have email,password,etc.
        //can be re-used
        session.setAttribute("Email", Email);
        session.setAttribute("Password", Password);
        session.setAttribute("Firstname", Firstname);
        session.setAttribute("Lastname", Lastname);
        }
        
        
        try
        {
        Connector = new DBConnector();
        Query = new DBManager(Connector.openConnection());
        }catch (ClassNotFoundException | SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        try
        {
        list = Query.List_Location();//run query
        Connector.closeConnection();//close connection
        session.setAttribute("List", list);//set attribute to be redirected
        session.setAttribute("Redirect", Redirect);
        }
        catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        response.sendRedirect("701_List_Location.jsp");//redirect to index.html page
    }
}
