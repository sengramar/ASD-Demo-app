/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michael, Nayoon
 */

package Controller;

import DAO.MongoDBManager;
import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.User;


@WebServlet(name = "IndexRegister_Servlet", urlPatterns = {"/IndexRegister_Servlet"})
public class IndexRegister_Servlet extends HttpServlet 
{
    //set DBConnector and Manager as private attribute so I can call anytime and close it when finish executing query
    private MongoDBManager Query;
    private LinkedList list;
    private MongoDBManager Mongo  = new MongoDBManager();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String Redirect = (String) request.getParameter("Redirect");
        
        String Email = (String) request.getParameter("Email");
        String Password = (String) request.getParameter("Password");
        String Firstname = (String) request.getParameter("Firstname");
        String Lastname = (String) request.getParameter("Lastname");
        int LocationID = (Integer) Integer.parseInt(request.getParameter("LocationID"));
        
        String Empty="";
            session.setAttribute("Email", Empty);
            session.setAttribute("Password", Empty);
            session.setAttribute("Firstname", Empty);
            session.setAttribute("Lastname", Empty);
            session.setAttribute("LocationID", 0);
            Mongo.saveToUser(Password, Email, Firstname, Lastname, LocationID);
        
        session.setAttribute("List", list);
        session.setAttribute("Redirect", Redirect);

        response.sendRedirect("101_register.jsp");//redirect to index.html page
    }
}
