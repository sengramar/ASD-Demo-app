/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DBManager;
import Model.User;
import java.io.PrintWriter;
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

@WebServlet (name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        try {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user = (User) session.getAttribute("user");
        int userID = user.getUserId();
        String logoutDateTime;
            java.util.Date date = new java.util.Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            logoutDateTime = formatter.format(date);
            
            int accesslogId = manager.findAccessLogID(userID);
            manager.storeLogout(accesslogId, logoutDateTime);
            session.invalidate();
            request.getRequestDispatcher("202_logout.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
