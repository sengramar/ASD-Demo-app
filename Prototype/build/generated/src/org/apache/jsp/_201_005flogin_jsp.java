package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.User;

public final class _201_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\"/>\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    ");

            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
    
      out.write("\n");
      out.write("    <center>     \n");
      out.write("        <h1 class=\"header\">Sign Up</h1><span>");
      out.print((existErr != null ? existErr : ""));
      out.write("</span><br>\n");
      out.write("        <div class=\"regbox\">\n");
      out.write("        <form method=\"post\" name=\"form\" action=\"Login_Servlet\">\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("            <td><p class=\"subtitle\"><label for=\"Email\">Email</label></p></td>\n");
      out.write("                <td><p>&nbsp;</p></td>\n");
      out.write("                <td><p><input type=\"Email\" name=\"Email\"required=\"True\" placeholder=\"");
      out.print((emailErr != null ? emailErr : "Enter email"));
      out.write("\"></p></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("            <td><p class=\"subtitle\"><label for=\"Password\">Password</label></p></td>\n");
      out.write("                <td><p>&nbsp;</p></td>\n");
      out.write("                <td><p><input type=\"Password\" name=\"Password\" required=\"True\"  placeholder=\"");
      out.print((passErr != null ? passErr : "Enter password"));
      out.write("\"></p></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <button type=\"submit\"> Login </button>\n");
      out.write("        <button><a href=\"index.jsp\"> Cancel</a> </button>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("   </center>\n");
      out.write("\n");
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
