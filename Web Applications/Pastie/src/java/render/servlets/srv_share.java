
package render.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import render.DB;


public class srv_share extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String islem = request.getParameter("islem");
        String id = request.getParameter("share_id");
        
        try
        {
            DB db = new DB();
            
            if (islem.equals("sil"))
            {
                db.execute("delete from shares where id = "+id);
            }
            
            if (islem.equals("upd"))
            {
                db.execute("update shares set is_public = (is_public+1) % 2 where id = "+id);
            }
            
            response.getWriter().println("ok");
        } catch (Exception e) { e.printStackTrace(); }
    }

    public String getServletInfo() 
    {
        return "Short description";
    }
}
