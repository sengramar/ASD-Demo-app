/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DBConnector;
import DAO.DBManager;
import DAO.MongoDBManager;
import Model.Administrator;
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

/**
 *
 * @author yses9
 */

@WebServlet(name = "AdminLogin_Servlet", urlPatterns = {"/AdminLogin_Servlet"})
public class AdminLogin_Servlet extends HttpServlet  {    
  
    private MongoDBManager Mongo = new MongoDBManager();
    
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
        
        Administrator admin=null;
        admin =  Mongo.findAdmin(Email, adminPassword);
        if (admin != null) 
        {
            
            session.setAttribute("admin", admin);
            response.sendRedirect("adminMain.jsp");
            int adminId = admin.getAdminId();
            Mongo.storeAdminLogin(adminId, loginDateTime);

        }
        else {
            session.setAttribute("existErr", " - Email or password incorrect");
            response.sendRedirect("203_AdminLogin.jsp");
            
        }

            
    }
}
