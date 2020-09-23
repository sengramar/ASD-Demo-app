/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "IndexAdminRegister_Servlet", urlPatterns = {"/IndexAdminRegister_Servlet"})
public class IndexAdminRegister_Servlet extends HttpServlet {

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

        response.sendRedirect("101_register_admin.jsp");
    }

}
