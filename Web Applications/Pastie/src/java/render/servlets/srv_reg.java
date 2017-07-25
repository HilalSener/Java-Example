
package render.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import render.DB;


public class srv_reg extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String em = request.getParameter("em");
        String pw = request.getParameter("pw");
        String ad = request.getParameter("ad");
        
        String sql = "insert into users values (0, '%s', '%s', '%s')";
        sql = String.format(sql, ad, em, pw);
        
        try
        {
            DB db = new DB();
            db.execute(sql);
            response.getWriter().println("reg;1");
        } catch (Exception e) { e.printStackTrace(); response.getWriter().println("reg;0"); }
    }

    public String getServletInfo() 
    {
        return "Short description";
    }
}
