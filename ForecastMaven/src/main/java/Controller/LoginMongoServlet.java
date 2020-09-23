/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MongoDBManager;
import Model.User;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yses9
 */

@WebServlet(name = "LoginMongoServlet", urlPatterns = {"/LoginMongoServlet"})
public class LoginMongoServlet extends HttpServlet  {    
   // @Override
    private MongoDBManager Mongo = new MongoDBManager();;
    
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
        

        //DBManager manager = (DBManager) session.getAttribute("manager");
        User user=null;
        user =  Mongo.findUser(Email, User_Password);
        if (user != null) 
        {
            
            session.setAttribute("user", user);
            response.sendRedirect("main.jsp");
            int userId = user.getUserId();
            //manager.storeLogin(userId, loginDateTime);
            //Remember to User history log
        }
        else {
            session.setAttribute("existErr", " - Email or password incorrect");
            response.sendRedirect("201_login.jsp");
            
             }
            

            
    }
}
