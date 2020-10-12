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
    private MongoDBManager Query = new MongoDBManager();;
    private LinkedList list;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String Search_txt_box;
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        if(request.getParameter("search").equals(""))
        {
            Search_txt_box = " ";
        }
        else
        {
            Search_txt_box = (String) request.getParameter("search");
        }
        String Search = Search_txt_box.substring(0, 1).toUpperCase() + Search_txt_box.substring(1); 
        list = Query.List_Location(Search);//run query
        
        session.setAttribute("List", list);//set attribute to be redirected
        
        response.sendRedirect("701_List_Location.jsp");//redirect to index.html page
    }
}
