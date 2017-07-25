package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Firebase Ornek</title>\n");
      out.write("\n");
      out.write("        <script src=\"https://www.gstatic.com/firebasejs/4.1.3/firebase.js\"></script>\n");
      out.write("        <script src=\"https://www.gstatic.com/firebasejs/4.1.3/firebase-app.js\"></script>\n");
      out.write("        <script src=\"https://www.gstatic.com/firebasejs/4.1.3/firebase-auth.js\"></script>\n");
      out.write("        <script src=\"https://www.gstatic.com/firebasejs/4.1.3/firebase-database.js\"></script>\n");
      out.write("        <script src=\"https://www.gstatic.com/firebasejs/4.1.3/firebase-messaging.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            // Initialize Firebase\n");
      out.write("            var config = {\n");
      out.write("                apiKey: \"AIzaSyDpHXXkCVlpWT6KGFC-22w1-_h0HXFHah0\",\n");
      out.write("                authDomain: \"myapp-4f43a.firebaseapp.com\",\n");
      out.write("                databaseURL: \"https://myapp-4f43a.firebaseio.com\",\n");
      out.write("                projectId: \"myapp-4f43a\",\n");
      out.write("                storageBucket: \"myapp-4f43a.appspot.com\",\n");
      out.write("                messagingSenderId: \"77697197765\"\n");
      out.write("            };\n");
      out.write("            var app = firebase.initializeApp(config);\n");
      out.write("            var db = app.database();\n");
      out.write("\n");
      out.write("            var myBook = {\n");
      out.write("                id: \"kitap001\",\n");
      out.write("                author: \"Falan Filan\",\n");
      out.write("                title: \"Calismiyor\",\n");
      out.write("                genre: \"Firebase\",\n");
      out.write("                price: \"25\",\n");
      out.write("                publish_date: \"2017-07-12\",\n");
      out.write("                description: \"Realtime DB Aciklama\"\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            function writeUserData(userId, name, email, imageUrl) {\n");
      out.write("                firebase.db().ref('kitaplar/' + \"12\").set({\n");
      out.write("                    myBook;\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
