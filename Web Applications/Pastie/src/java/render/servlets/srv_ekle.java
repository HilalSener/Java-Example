
package render.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import render.DB;


public class srv_ekle extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    
        String ad = request.getParameter("ad");
        String tur = request.getParameter("tur");
        String isPublic = request.getParameter("public");
        String content = request.getParameter("content");
        
        HttpSession session = request.getSession();
        String user_id = session.getAttribute("id").toString();
        
        try
        {
            String sql = "insert into shares values (0, %s, now(), '%s', '%s', '%s', %s)";
            sql = String.format(sql, user_id, ad, content, tur, isPublic);
            System.out.println("******************");
            System.out.println(sql);
            DB db = new DB();
            db.execute(sql);
            
            ResultSet ss = db.query("select max(id) as 'mid' from shares where user_id = "+user_id);
            ss.next();
            String maxId = ss.getString("mid");
            
            response.getWriter().println(maxId);
            
        } catch (Exception e) { response.getWriter().println(e.toString()); }
    }

    public String getServletInfo() 
    {
        return "Short description";
    }
}
