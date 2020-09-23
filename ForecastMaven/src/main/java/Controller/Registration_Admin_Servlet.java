/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DBConnector;
import DAO.DBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nayoon
 */
@WebServlet(name = "Registration_Admin_Servlet", urlPatterns = {"/Registration_Admin_Servlet"})
public class Registration_Admin_Servlet extends HttpServlet {

    private DBConnector Connector;
    private DBManager Query;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {               
        String Email = (String) request.getParameter("Email");
        String Password = (String) request.getParameter("Password");
        String Firstname = (String) request.getParameter("Firstname");
        String Lastname = (String) request.getParameter("Lastname");

        response.setContentType("text/html;charset=UTF-8");
        try
        {
            Connector = new DBConnector();//open new connector
            Query = new DBManager(Connector.openConnection()); //open connection 
        }catch (ClassNotFoundException | SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        try
        {
        Query.CreateAdmin(Email,Password,Firstname,Lastname);//run query
        Connector.closeConnection();//close connection
        }
        catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        response.sendRedirect("index.jsp");
    }
}
