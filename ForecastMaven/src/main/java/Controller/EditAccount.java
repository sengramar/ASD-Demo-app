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
/**
 *
 * @author bert_
 */
public class EditAccount extends HttpServlet {
    
             private DBConnector Connector;
            private DBManager Query;
    
     @Override   
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             //1- retrieve the current session
             HttpSession session = request.getSession();
             
             
             
             int userId = Integer.parseInt(request.getParameter("userId"));
             String firstname= request.getParameter("firstname");
             String lastname = request.getParameter("lastname");
             String email= request.getParameter("email");
             String password= request.getParameter("password");
             int location = Integer.parseInt(request.getParameter("location"));
             
             
             User user = new User (userId, location, password, email, firstname, lastname);
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
            Query.updateUser(userId, location, password, email, firstname, lastname);//run query
            Connector.closeConnection();//close connection
        }
        catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        if(user != null){
                                session.setAttribute("user", user);
                                
                                session.setAttribute("updated"," : Upadte was Successful");
                                request.getRequestDispatcher("301_account_management.jsp").include(request,response);
                            }else{
                                session.setAttribute("updated"," : Upadte was NOT Successful");
                                request.getRequestDispatcher("301_account_management.jsp").include(request,response);
                            }
                     
                     response.sendRedirect("301_account_management.jsp");
     }
    
}
