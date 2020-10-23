/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.*;
import Model.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
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

@WebServlet(name = "LoginMongoServlet", urlPatterns = {"/LoginMongoServlet"})
public class LoginMongoServlet extends HttpServlet  {    
   // @Override
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
        String User_Password = (String) request.getParameter("Password");
        
        Validator.clear(session);
        if (!Validator.validateEmail(Email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            response.sendRedirect("203_AdminLogin.jsp");
        }
        else if (!Validator.validatePassword(User_Password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
           response.sendRedirect("203_AdminLogin.jsp");
        }
        else{
            User user=null;
            user =  Query.findUser(Email, User_Password);

            if (user != null) {
                session.setAttribute("user", user);
                response.sendRedirect("main.jsp");
                int userId = user.getUserId();
                int AccessLogId = Query.returnID(accesslog,"accesslogId");
                Query.storeLogin(AccessLogId, userId, loginDateTime);
                session.setAttribute("AccessLogId", AccessLogId);              
            }
            else {
                session.setAttribute("existErr", " - Email or password incorrect");
                response.sendRedirect("201_login.jsp");

            }
        }
    }
}
