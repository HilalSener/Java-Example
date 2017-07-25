
<%@page import="java.sql.ResultSet"%>
<%@page import="jsp.ornek.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            DB db = new DB();
            ResultSet rs = db.execute("select yaziid, baslik, tarih from tblyazilar");
               
        %>
        <table style='width: 100%; border: 1px'>
            <thead>
                <tr>
                    <th>Yazı ID</th>
                    <th>Baslik</th>
                    <th>Tarih</th>
                </tr>
            </thead>
            
            <tbody>
                <% 
                    while(rs.next())
                    {
                        /*
                        out.println("<tr>");
                        out.println("<td>" + rs.getString(1) + "</td>");
                        out.println("<td>" + rs.getString(2) + "</td>");
                        out.println("<td>" + rs.getString(3) + "</td>");
                        out.println("</tr>");
                        */
                        %>
                        <tr>
                            <td><%=rs.getString(1)%></td>
                            <td><%=rs.getString(2)%></td>
                            <td><%=rs.getString(3)%></td>
                        </tr>
                        <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
