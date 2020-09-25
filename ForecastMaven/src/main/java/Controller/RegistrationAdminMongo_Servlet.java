/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import java.sql.SQLException;
import java.util.logging.Level;
import Model.Administrator;

/**
 *
 * @author Nayoon
 */
@WebServlet(name = "RegistrationAdminMongo_Servlet", urlPatterns = {"/RegistrationAdminMongo_Servlet"})
public class RegistrationAdminMongo_Servlet extends HttpServlet {

    private MongoDBConnector Connector;
    private MongoDBManager Query;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {               
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        String Email = (String) request.getParameter("Email");
        String Password = (String) request.getParameter("Password");
        String Firstname = (String) request.getParameter("Firstname");
        String Lastname = (String) request.getParameter("Lastname");
        
        Administrator admin = null;
        admin = Query.findAdmin(Email, Password);
        if (admin != null)
        {
            session.setAttribute("existErr", "You are already registered");
            response.sendRedirect("102_register.jsp");
        }
        else {
            Connector = new MongoDBConnector();
            Query = new MongoDBManager();
            Query.saveToAdmin(Password, Email, Firstname, Lastname);
            response.sendRedirect("index.jsp");
        }
    }
}
