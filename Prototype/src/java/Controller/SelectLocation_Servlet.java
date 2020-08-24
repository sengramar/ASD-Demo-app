/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michael
 */

package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SelectLocation_Servlet", urlPatterns = {"/SelectLocation_Servlet"})
public class SelectLocation_Servlet extends HttpServlet 
{
    //set DBConnector and Manager as private attribute so I can call anytime and close it when finish executing query
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String Email = (String) session.getAttribute("Email");
        String Password = (String) session.getAttribute("Password");
        String Firstname = (String) session.getAttribute("Firstname");
        String Lastname = (String) session.getAttribute("Lastname");
        
        
        int LocationID = Integer.parseInt(request.getParameter("ID"));
        String State = request.getParameter("State");
        response.setContentType("text/html;charset=UTF-8");
        
        session.setAttribute("Email", Email);
        session.setAttribute("Password", Password);
        session.setAttribute("Firstname", Firstname);
        session.setAttribute("Lastname", Lastname);
        
        session.setAttribute("State", State);
        session.setAttribute("LocationID", LocationID);

        response.sendRedirect("101_register.jsp");//redirect to index.html page
    }
}
