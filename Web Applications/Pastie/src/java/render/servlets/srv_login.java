
package render.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import render.DB;


public class srv_login extends HttpServlet 
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
        
        String sql = "select count(*) as 'cnt', id, ad from users where un = '%s' and pw = '%s'";
        sql = String.format(sql, em, pw);
        
        try
        {
            DB db = new DB();
            ResultSet rs = db.query(sql);
            rs.next();
            int cnt = rs.getInt("cnt");
            
            if (cnt == 0)
            {
                response.getWriter().printf("login;0");
            }
            else
            {
                HttpSession session = request.getSession();
                session.putValue("id", rs.getString("id"));
                session.putValue("ad", rs.getString("ad"));
                
                response.getWriter().printf("login;1");
            }
            
            rs.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public String getServletInfo() 
    {
        return "Short description";
    }
}
