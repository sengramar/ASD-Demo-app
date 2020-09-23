/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DBConnector;
import DAO.DBManager;
import Model.User;
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

@WebServlet(name = "Login_Servlet", urlPatterns = {"/Login_Servlet"})
public class Login_Servlet extends HttpServlet  {    
   // @Override
        private DBConnector Connector;
        private DBManager manager;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {               
        String loginDateTime;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        loginDateTime = formatter.format(date);
        HttpSession session = request.getSession();
        try
        {
            Connector = new DBConnector();//open new connector
            manager = new DBManager(Connector.openConnection()); //open connection 
        }catch (ClassNotFoundException | SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        String Email = (String) request.getParameter("Email");
        String User_Password = (String) request.getParameter("User_Password");
        System.out.println("test");
        //DBManager manager = (DBManager) session.getAttribute("manager");
        User user=null;
        int userId;
        
            try {
                user = manager.FindUser(Email, User_Password);
            }
                 catch (SQLException | NullPointerException ex) {           
                System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
                //response.sendRedirect("201_login.jsp");
            }
                if (user != null) {
                   try {
                    session.setAttribute("user", user);
                    response.sendRedirect("main.jsp");
                    userId = user.getUserId();
                    manager.storeLogin(userId, loginDateTime);
            } catch (SQLException ex) {
                Logger.getLogger(Login_Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                else {
                    session.setAttribute("existErr", " - Email or password incorrect");
                    response.sendRedirect("201_login.jsp");
                    //request.getRequestDispatcher("201_login.jsp").include(request, response);
                }
            

            
    }
}
