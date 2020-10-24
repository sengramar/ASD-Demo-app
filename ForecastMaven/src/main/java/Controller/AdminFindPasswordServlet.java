/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.Random;
import java.util.Properties;

import DAO.*;
import Model.*;
import API.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.Document;

/**
 *
 * @author yses9
 */

@WebServlet(name = "AdminFindPasswordServlet", urlPatterns = {"/AdminFindPasswordServlet"})
public class AdminFindPasswordServlet extends HttpServlet  {
    private MongoDBConnector Mongo = new MongoDBConnector();
    private MongoDatabase db = Mongo.DBConnect();
    private MongoDBManager Query = new MongoDBManager();
    MongoDBManager MongoManager = new MongoDBManager();
	Mail passemail = new Mail();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {     
        HttpSession session = request.getSession();
        String Email = (String) request.getParameter("Email");
        String Firstname = (String) request.getParameter("Firstname");
        String Lastname = (String) request.getParameter("Lastname");
        
        Validator.clear(session);
        if (!Validator.validateEmail(Email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            response.sendRedirect("205_AdminFindPassword.jsp");
        } 
        else if (!Validator.validateName(Firstname)) {
            session.setAttribute("error", "First Name format is wrong");
            response.sendRedirect("205_AdminFindPassword.jsp");
        }
        else if (!Validator.validateName(Lastname)) {
            session.setAttribute("error", "Last Name format is wrong");
            response.sendRedirect("205_AdminFindPassword.jsp");
        }
        else {
            Administrator checkAdmin = null;
            checkAdmin =  Query.checkAdmin(Email);
            
            if (checkAdmin != null){
              session.setAttribute("checkAdmin", checkAdmin);
              int adminID = Query.findAdminID(Email,Firstname,Lastname);
              String pass = checkAdmin.randomPassword();
              MongoManager.updateAdminPass(adminID, pass);
              System.out.println(pass);
              String message = "Your temporary password is" + " "+ pass;
              System.out.println(message);
              passemail.SendMail(Email,message);

              session.setAttribute("SentEmail", "Message sent successfully");
//              session.setAttribute("tempMsg", "Your temporary password is" + " "+ pass);
              request.getRequestDispatcher("205_AdminFindPassword.jsp").include(request,response);
            }else {
                 session.setAttribute("existErr", "Account does not exist");
                 request.getRequestDispatcher("205_AdminFindPassword.jsp").include(request,response);
            }
        }
        response.sendRedirect("205_AdminFindPassword.jsp");
    }
}
