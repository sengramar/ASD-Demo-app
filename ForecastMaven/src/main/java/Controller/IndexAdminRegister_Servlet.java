/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import Model.Administrator;

/**
 *
 * @author Nayoon
 */
@WebServlet(name = "IndexAdminRegister_Servlet", urlPatterns = {"/IndexAdminRegister_Servlet"})
public class IndexAdminRegister_Servlet extends HttpServlet {

    private MongoDBManager Query;
    private LinkedList list;
    private MongoDBManager Mongo = new MongoDBManager();
    
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
        
        String Empty="";

            session.setAttribute("Email", Email);
            session.setAttribute("Password", Password);
            session.setAttribute("Firstname", Firstname);
            session.setAttribute("Lastname", Lastname);
            Mongo.saveToAdmin(Password, Email, Firstname, Lastname);
            Query = new MongoDBManager();
            list = Query.List_Admin("");

        session.setAttribute("List", list);
        session.setAttribute("Redirect", Redirect);
        
        response.sendRedirect("103_register_admin.jsp");
    }

}
