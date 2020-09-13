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


@WebServlet(name = "IndexRegister_Servlet", urlPatterns = {"/IndexRegister_Servlet"})
public class IndexRegister_Servlet extends HttpServlet 
{
    //set DBConnector and Manager as private attribute so I can call anytime and close it when finish executing query
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        
        String Empty="";
        session.setAttribute("Email", Empty);
        session.setAttribute("Password", Empty);
        session.setAttribute("Firstname", Empty);
        session.setAttribute("Lastname", Empty);

        session.setAttribute("State", Empty);
        session.setAttribute("LocationID", 0);

        response.sendRedirect("101_register.jsp");//redirect to index.html page
    }
}
