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
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nayoon
 */
@WebServlet(name = "CheckAdminServlet", urlPatterns = {"/CheckAdminServlet"})
public class CheckAdminServlet extends HttpServlet {

    private DBConnector Connector;
    private DBManager Query;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {               
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String adminKey = request.getParameter("adminKey");
        validator.clear(session);
        
        if (!validator.validateAdminKey(adminKey)) {
            session.setAttribute("adminKeyErr", "Error: Admin Key format incorrect");
            request.getRequestDispatcher("101_check_admin.jsp").include(request, response);
        } else {
            try {
                session.setAttribute("adminKey", adminKey);
                request.getRequestDispatcher("101_check_admin.jsp").include(request, response);
                Connector.closeConnection();
            } 
            catch (SQLException ex) {
                Logger.getLogger(CheckAdminServlet.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
    }
}
