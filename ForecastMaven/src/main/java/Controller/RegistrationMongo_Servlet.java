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
import Model.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nayoon
 */
@WebServlet(name = "RegistrationMongo_Servlet", urlPatterns = {"/RegistrationMongo_Servlet"})
public class RegistrationMongo_Servlet extends HttpServlet {
    
    private MongoDBManager Mongo = new MongoDBManager();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {               
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        String Email = (String) request.getParameter("Email");
        String Password = (String) request.getParameter("Password");
        String Firstname = (String) request.getParameter("Firstname");
        String Lastname = (String) request.getParameter("Lastname");
        int LocationID = (Integer) Integer.parseInt(request.getParameter("LocationID"));
        
        User user = null;
        user = Mongo.findUser(Email, Password);
        if (user != null)
        {
            session.setAttribute("existErr", "You are already registered");
            request.getRequestDispatcher("101_register.jsp").include(request,response);
        }
        else if (!validator.validateEmail(Email))
        {
            session.setAttribute("error", "Email format is wrong");
            request.getRequestDispatcher("101_register.jsp").include(request,response);
        }
        else if (!validator.validatePassword(Password)) {
            session.setAttribute("error", "Your password must include special character, number");
            request.getRequestDispatcher("101_register.jsp").include(request,response);
        }
        else if (!validator.validateName(Firstname)) {
            session.setAttribute("error", "First Name format is wrong");
            request.getRequestDispatcher("101_register.jsp").include(request,response);
        }
        else if (!validator.validateName(Lastname)) {
            session.setAttribute("error", "Last Name format is wrong");
            request.getRequestDispatcher("101_register.jsp").include(request,response);
        }
        else if (LocationID == 0) 
        {
            session.setAttribute("error", "Haven't select the location");
            request.getRequestDispatcher("101_register.jsp").include(request,response);
        }
        else {
            Mongo.saveToUser(Password, Email, Firstname, Lastname,LocationID);
            response.sendRedirect("index.jsp");
        }
    }
}