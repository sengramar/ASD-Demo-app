/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DBConnector;
import DAO.DBManager;
import DAO.MongoDBConnector;
import DAO.MongoDBManager;
import Model.Administrator;
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

@WebServlet(name = "AdminLogin_Servlet", urlPatterns = {"/AdminLogin_Servlet"})
public class AdminLogin_Servlet extends HttpServlet  {    
  
    private MongoDBConnector Mongo = new MongoDBConnector();
    private MongoDatabase db = Mongo.DBConnect();
    private MongoDBManager Query = new MongoDBManager();
    private MongoCollection<Document> accesslog = db.getCollection("AccessLog");
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {               
        String loginDateTime;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        loginDateTime = formatter.format(date);
        HttpSession session = request.getSession();
   
        String Email = (String) request.getParameter("Email");
        String adminPassword = (String) request.getParameter("Password");
                
       Validator.clear(session);
        if (!Validator.validateEmail(Email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            response.sendRedirect("203_AdminLogin.jsp");
        }
        else if (!Validator.validatePassword(adminPassword)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
           response.sendRedirect("203_AdminLogin.jsp");
        }
        else{
        Administrator admin=null;
        admin =  Query.findAdmin(Email, adminPassword);
        if (admin != null) 
        {
            
            session.setAttribute("admin", admin);
            response.sendRedirect("adminMain.jsp");
            int adminId = admin.getAdminId();
            int AccessLogId = Query.returnID(accesslog,"accesslogId");
            Query.storeAdminLogin(AccessLogId, adminId, loginDateTime);
            
            session.setAttribute("AccessLogId", AccessLogId);

        }
        else {
            session.setAttribute("existErr", " - Email or password incorrect");
            response.sendRedirect("203_AdminLogin.jsp");
            
        }

      }
    }
}
