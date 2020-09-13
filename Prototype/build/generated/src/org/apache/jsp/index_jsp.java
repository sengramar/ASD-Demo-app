package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.DBManager;
import Model.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\"/>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");

            User user = (User)session.getAttribute("customer");
            DBManager manager = (DBManager)session.getAttribute("manager"); 
            String email = request.getParameter("Email");
            String password = request.getParameter("Password");
    
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"sidenav\">\n");
      out.write("            <br><br>\n");
      out.write("            <a href=\"/Prototype\">HOME</a>\n");
      out.write("            <form name=\"submitForm\" method=\"POST\" action=\"CurrentWeather_Servlet\">\n");
      out.write("            <input type=\"hidden\" name=\"param1\" value=\"param1Value\">\n");
      out.write("            <a HREF=\"javascript:document.submitForm.submit()\">CURRENT WEATHER</a></form>\n");
      out.write("            <a href=\"501_weather_forecast.jsp\">WEATHER FORECAST</a>\n");
      out.write("            <a href=\"601_weather_history.jsp\">WEATHER HISTORY</a>\n");
      out.write("            <a href=\"901_weather_analysis.jsp\">WEATHER ANALYSIS</a>\n");
      out.write("            <a href=\"301_account_management.jsp\">ACCOUNT MANAGEMENT</a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <br><br>\n");
      out.write("            <center>\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <h1>Weather Now</h1>\n");
      out.write("            </div>\n");
      out.write("            </center>\n");
      out.write("            \n");
      out.write("            <p align=\"center\">Lulu lala I hope it wont be raining</p>\n");
      out.write("        <form action=\"IndexRegister_Servlet\" method=\"POST\">\n");
      out.write("            <button type=\"submit\" class=\"button\">Register</button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("  <div class=\"w3-container w3-padding-32\" id=\"projects\">\n");
      out.write("      <h3 class=\"w3-border-bottom w3-border-light-grey w3-padding-16\">Pages</h3>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"w3-row-padding\">\n");
      out.write("    <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("      <div class=\"w3-display-container\">\n");
      out.write("        <div class=\"w3-display-topleft w3-black w3-padding\">***</div>\n");
      out.write("        <img src=\"img/bus.JPG\" alt=\"bus\" style=\"width:100%\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("      <div class=\"w3-display-container\">\n");
      out.write("        <div class=\"w3-display-topleft w3-black w3-padding\">***</div>\n");
      out.write("        <img src=\"img/snow.JPG\" alt=\"snow\" style=\"width:100%\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("      <div class=\"w3-display-container\">\n");
      out.write("        <div class=\"w3-display-topleft w3-black w3-padding\">***</div>\n");
      out.write("        <img src=\"img/beach.JPG\" alt=\"beach\" style=\"width:100%\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("      <div class=\"w3-display-container\">\n");
      out.write("        <div class=\"w3-display-topleft w3-black w3-padding\">***</div>\n");
      out.write("        <img src=\"img/thunder.JPG\" alt=\"thunder\" style=\"width:100%\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"w3-row-padding\">\n");
      out.write("    <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("      <div class=\"w3-display-container\">\n");
      out.write("        <div class=\"w3-display-topleft w3-black w3-padding\">***</div>\n");
      out.write("        <img src=\"img/rain.JPG\" alt=\"rain\" style=\"width:99%\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("      <div class=\"w3-display-container\">\n");
      out.write("        <div class=\"w3-display-topleft w3-black w3-padding\">***</div>\n");
      out.write("        <img src=\"img/clean.JPG\" alt=\"clean\" style=\"width:99%\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("      <div class=\"w3-display-container\">\n");
      out.write("        <div class=\"w3-display-topleft w3-black w3-padding\">***</div>\n");
      out.write("        <img src=\"img/cloud.JPG\" alt=\"cloud\" style=\"width:99%\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"w3-col l3 m6 w3-margin-bottom\">\n");
      out.write("      <div class=\"w3-display-container\">\n");
      out.write("        <div class=\"w3-display-topleft w3-black w3-padding\">***</div>\n");
      out.write("        <img src=\"img/storm.JPG\" alt=\"storm\" style=\"width:99%\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
