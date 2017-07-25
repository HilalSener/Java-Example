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
            try {
                //Request ile gelen bilgileri UTF-8 kodlaması ile al
                request.setCharacterEncoding("UTF-8");
                
                DB db = new DB();
                String ad = request.getParameter("kisi_ad");
                String soyad = request.getParameter("kisi_soyad");
                String yas = request.getParameter("kisi_yas");
                
                /*
                out.println("Ad: " + ad + "<br/>");
                out.println("Soyad: " + ad + "<br/>");
                */
                 
                if(ad.isEmpty() || soyad.isEmpty() || yas.isEmpty())
                    return;
                
                String sql = "insert into kisiler values(0, '%s', '%s', '%s')";
                sql = String.format(sql, ad, soyad, yas);
                
                db.query(sql);
                //out.println("<h3>Yeni Kişi Eklendi</h3>");
                response.sendRedirect("form2.html");
            } 
            catch (Exception e) {
                out.println("<h1>Hata: " + e + "</h1>");
            }
        %>
    </body>
</html>
