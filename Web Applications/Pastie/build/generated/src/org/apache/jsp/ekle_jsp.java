package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import render.Page;

public final class ekle_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    
  boolean isLoggedIn = false;
    
    try
    {
        isLoggedIn = session.getAttribute("id") != null;
    } catch (Exception e) 
    {
        response.sendRedirect("login.jsp");
        isLoggedIn = false; 
    }  

    if (!isLoggedIn)
    {
        response.sendRedirect("login.jsp");
    }
    

      out.write("    \n");
 out.println(Page.getHeader("Yeni İçerik Ekle"));  
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <form id=\"ekleForm\">\n");
      out.write("    <div class=\"row\" style=\"margin-top:18px\">\n");
      out.write("        <div class=\"col-md-8\">\n");
      out.write("            <label>Paylaşım Adı</label>\n");
      out.write("            <input name=\"ad\" type=\"text\" class=\"form-control input\" required placeholder=\"Paylaşım Adınız Giriniz\" />\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"col-md-2\">\n");
      out.write("            <label>Paylaşım Türü</label>\n");
      out.write("            <select name=\"tur\" class=\"form-control input\" required>\n");
      out.write("                <option value=\"\">Seçiniz</option>\n");
      out.write("                <option value=\"txt\">Düz Metin</option>\n");
      out.write("                <option value=\"java\">Java</option>\n");
      out.write("                <option value=\"js\">JavaScript</option>\n");
      out.write("                <option value=\"php\">PHP</option>\n");
      out.write("                \n");
      out.write("            </select>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"col-md-2\">\n");
      out.write("            <label>Herkese Açık Mı</label>\n");
      out.write("            <select name=\"public\" class=\"form-control input\" required>\n");
      out.write("                <option value=\"\">Seçiniz</option>\n");
      out.write("                <option value=\"1\">Evet</option>\n");
      out.write("                <option value=\"0\">Hayır</option>\n");
      out.write("            </select>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"row\" style=\"margin-top:18px\">\n");
      out.write("        <div class=\"col-md-12\">\n");
      out.write("            <label>Paylaşılacak İçerik</label>\n");
      out.write("            <textarea name=\"content\" class=\"form-control input\" required placeholder=\"İçeriği Buraya Yazın\" style=\"height: 400px\"></textarea>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"row\" style=\"margin-top:18px\">\n");
      out.write("        <div class=\"col-md-12 text-right\">\n");
      out.write("        <button type=\"submit\" class=\"btn btn-lg btn-success\">Paylaş</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("$(\"#ekleForm\").submit(function(e)\n");
      out.write("{\n");
      out.write("    e.preventDefault();\n");
      out.write("    var degerler = $(this).serialize();\n");
      out.write("    alert(degerler);\n");
      out.write("    \n");
      out.write("    $.post(\"Servlet/srv_ekle\", degerler, function(d,s)\n");
      out.write("    {\n");
      out.write("        var sonuc = $.trim(d);\n");
      out.write("        \n");
      out.write("        location.href=\"http://localhost/8080/Pastie/\"+sonuc;\n");
      out.write("    });\n");
      out.write("    return false;\n");
      out.write("});    \n");
      out.write("    \n");
      out.write("</script>\n");
      out.write("\n");
 out.println(Page.getPageEnd()); 
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
