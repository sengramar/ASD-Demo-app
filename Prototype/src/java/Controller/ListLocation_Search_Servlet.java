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
        String Search_txt_box = (String) request.getParameter("search");
        String Search = Search_txt_box.substring(0, 1).toUpperCase() + Search_txt_box.substring(1);   
        
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
        list = Query.List_Location(Search);//run query
        Connector.closeConnection();//close connection
        session.setAttribute("List", list);//set attribute to be redirected
        }
        catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        response.sendRedirect("701_List_Location.jsp");//redirect to index.html page
    }
}
