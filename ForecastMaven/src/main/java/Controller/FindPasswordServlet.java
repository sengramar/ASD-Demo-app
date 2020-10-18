/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.Random;
import java.util.Properties;

import DAO.DBConnector;
import DAO.DBManager;
import DAO.MongoDBConnector;
import DAO.MongoDBManager;
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

@WebServlet(name = "FindPasswordServlet", urlPatterns = {"/FindPasswordServlet"})
public class FindPasswordServlet extends HttpServlet  {
    private MongoDBConnector Mongo = new MongoDBConnector();
    private MongoDatabase db = Mongo.DBConnect();
    private MongoDBManager Query = new MongoDBManager();
    MongoDBManager MongoManager = new MongoDBManager();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {     
        HttpSession session = request.getSession();
        String Email = (String) request.getParameter("Email");
//        int userId = (Integer) session.getAttribute("userId"); 
        Validator.clear(session);
        
        if (!Validator.validateEmail(Email)) 
        {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            response.sendRedirect("204_FindPassword.jsp");
        }
        else {
            User checkuser = null;
            Mail passemail = null;
            checkuser =  Query.checkUser(Email);
            
            if (checkuser != null){
              session.setAttribute("checkuser", checkuser);
              int userId = Query.finduserID(Email);
              System.out.println("test1");
              String pass = checkuser.randomPassword();
              System.out.println("test2");
              MongoManager.updatePass(userId, pass);
              System.out.println(pass);
              String message = "Your temporary password is" + " "+ pass;
              System.out.println(message);
              passemail.SendMail(Email,message);
              
              System.out.println("TEST8");
              session.setAttribute("SentEmail", "Message sent successfully");
              session.setAttribute("tempMsg", "Your temporary password is" + " "+ pass);
              request.getRequestDispatcher("204_FindPassword.jsp").include(request,response);
//                response.sendRedirect("204_FindPassword.jsp");
            }else {
                 session.setAttribute("existErr", "Account does not exist");
                 request.getRequestDispatcher("204_FindPassword.jsp").include(request,response);
            }
        }
        response.sendRedirect("204_FindPassword.jsp");
    }
}
