/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.*;
import DAO.MongoDBManager;
import Model.Location;
import Model.WeatherHistory;
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
 * @author yujiwon
 */
@WebServlet(name="WeatherAnalysis_Servlet", urlPatterns={"/WeatherAnalysis_Servlet"})
public class WeatherAnalysis_Servlet extends HttpServlet {

    private MongoDBManager mongo = new MongoDBManager();
    private LinkedList<WeatherHistory> wa_list;
            
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String elements = ""+request.getParameter("weatheranalysis");
        
        if(elements.equals("humidity"))
        {
            session.setAttribute("elements","humidity");
        }
        
        else if(elements.equals("cloudiness"))
        {
            session.setAttribute("elements","cloudiness");
        }
        
        else
        {
            session.setAttribute("elements","temperature");
        
        }
        
        String region = " "+request.getParameter("Region");
        System.out.println(request.getParameter("Region"));
        if(region.trim().equals("null"))
        {
               region = "Sydney";
               Location location = mongo.findLocationId(region);
               wa_list= mongo.weather_analysis(""+location.getLocationID());
        }
        
        else
        {
            Location location = mongo.findLocationId(region.trim());
            wa_list= mongo.weather_analysis(""+location.getLocationID());
        }
        
        session.setAttribute("wa_list",wa_list);
        session.setAttribute("Region",region);
        response.sendRedirect("901_weather_analysis.jsp");
        
        
    }  
}
