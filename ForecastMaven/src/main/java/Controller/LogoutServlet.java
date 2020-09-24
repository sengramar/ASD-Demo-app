/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DBConnector;
import DAO.DBManager;
import DAO.MongoDBManager;
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

@WebServlet (name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {
    //@Override
    private MongoDBManager Mongo = new MongoDBManager();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        String logoutDateTime;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logoutDateTime = formatter.format(date);
        HttpSession session = request.getSession();
        //            int accesslogId = Query.findAccessLogID(userID);
        //            Query.storeLogout(accesslogId, logoutDateTime);
        User user = (User) session.getAttribute("user");
        int userID = user.getUserId();
        session.invalidate();
        response.sendRedirect("index.jsp");
        
    }

}
