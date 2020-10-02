package Controller;

import DAO.DBConnector;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.User;
import DAO.DBManager;
import DAO.MongoDBManager;
import javax.servlet.annotation.WebServlet;
/**
 *
 */
@WebServlet(name = "DeleteAccount_Servlet", urlPatterns = {"/DeleteAccount_Servlet"})
   
public class DeleteAccount_Servlet extends HttpServlet {
    
            //private DBConnector Connector;
            //private DBManager Query;
    
    
    MongoDBManager MongoManager = new MongoDBManager();
    
     @Override   
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             //1- retrieve the current session
             HttpSession session = request.getSession();
             
             int userId = Integer.parseInt(request.getParameter("userId"));
             String email= request.getParameter("email");
             String password= request.getParameter("password");
             
             
             User user=null;
             user =  MongoManager.findUser(email, password);
            
        if(user != null)
        {
            session.setAttribute("user", user);
            MongoManager.deleteUser(userId);//run query
            session.setAttribute("updated"," : Delete was Successful");
            request.getRequestDispatcher("304_delete_account.jsp").include(request,response);
        }
        else
        {
            session.setAttribute("updated"," : Delete was NOT Successful");
            request.getRequestDispatcher("304_delete_account_failed.jsp").include(request,response);
                            
        }
                     
        response.sendRedirect("304_delete_account.jsp");
     }
}
