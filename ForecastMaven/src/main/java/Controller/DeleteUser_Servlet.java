
package Controller;

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
/**
 *
 * @author Hazel
 */
public class DeleteUser_Servlet extends HttpServlet {
    
     @Override   
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             //1- retrieve the current session
             HttpSession session = request.getSession();
             //2- create an instance of the Validator class  
             Validator validator = new Validator();
             //3- capture the posted email and password
             String userEmail= request.getParameter("email");
             String userPassword = request.getParameter("password");
             //4- retrieve the manager instance from session
             DBManager manager = (DBManager) session.getAttribute ("manager");
             
                     try {          
                            //6- find user by email and password
                            User user = manager.FindUser(userEmail,userPassword);
                            if(user != null){
                                manager.deleteUser(userEmail);
                                request.getRequestDispatcher("305_delete_succeed.jsp").include(request,response);
                            }else{
                                session.setAttribute("existErr", "User Does Not Exists");
                                request.getRequestDispatcher("305_delete_account.jsp").include(request,response);
                            }
                     } catch (SQLException ex) {           
                           Logger.getLogger(DeleteUser_Servlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
     }
}