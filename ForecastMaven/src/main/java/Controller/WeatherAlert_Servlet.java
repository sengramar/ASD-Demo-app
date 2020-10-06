/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import API.weatherAPI;
import DAO.MongoDBManager;
import Model.User;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "WeatherAlert_Servlet", urlPatterns = {"/WeatherAlert_Servlet"})
public class WeatherAlert_Servlet extends HttpServlet {
    MongoDBManager Mongo = new MongoDBManager();
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        int userId = Integer.parseInt(request.getParameter("userId"));
        String Email = (String) request.getParameter("Email");
        String Password = (String) request.getParameter("Password");
        int LocationID = (Integer) Integer.parseInt(request.getParameter("LocationID"));
        
//        String Country = request.getParameter("Country");
//        String Region = request.getParameter("Region");
//            
//        String Location = Region + ","+ Country;
//        session.setAttribute("Location", Location);
//        session.setAttribute("LocationID", LocationID);
//
//        RequestDispatcher rd = request.getRequestDispatcher("CurrentWeather_Servlet");
//        rd.forward(request, response);

        response.sendRedirect("alert.jsp");
     }
}
