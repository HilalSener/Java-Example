<%@page import="java.sql.ResultSet"%>
<%@page import="wissen.ziyaretci.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ziyaretçi Defteri</title>
        <!-- JQUERY -->
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            /*
                index.jsp    index.jsp?p=1     0 - 10
                index.jsp    index.jsp?p=2     10 - 20
             */

            int p = 0;
            
            int once = 0, sonra = 0;
            try {
                once = new Integer(request.getParameter("p")) - 1;
                sonra = new Integer(request.getParameter("p")) + 1;
                p = new Integer(request.getParameter("p")) - 1;
            } catch (Exception e) {
            }

            DB db = new DB();
            int basla = p * 10;
            int bitis = 10;
            
            //Sayfa sayısını bul
            ResultSet rs = db.execute("select ceil (count(*)/10) as 'pgcnt' from mesajlar;"); 
            rs.next();
            int pageCount = rs.getInt(1);
            
            rs.close();

            ResultSet rsMesaj = db.execute("select concat(ad, ' ', soyad) as 'kisi', date_format(tarih, '%d.%m.%Y %H:%,:%s') as 'tarih', metin from mesajlar limit " + basla + ", " + bitis);

            /*
            while(rsMesaj.next())
            {
                out.println("<p>" + rsMesaj.getString("id") + rsMesaj.getString("ad") + "</p>");
            }
             */
            
        %>
        <div class="container">
            <% while (rsMesaj.next()) {
                    String kisi = rsMesaj.getString("kisi");
                    String metin = rsMesaj.getString("metin");
                    String tarih = rsMesaj.getString("tarih");
            %>
            <div class='row'>
                <div class='col-md-12'>
                    <div class="panel panel-default">
                        <div class="panel-heading"><%=kisi%></div>
                        <div class="panel-body">
                            <%=metin%>
                        </div>
                        <div class="panel-footer text-right">
                            <%=tarih%>
                        </div>
                    </div>
                </div>
            </div>
            <% }%>
            <div id="sayfalama" class="col-md-12 text-center" style="margin-top: 20px">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <% if(once != 0) { %>
                        <li>
                            <a href="index.jsp?p=<%=once%>" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <% } %>
                        <% for (int i = 1; i <= pageCount; i++) { %>
                            <li><a href="index.jsp?p=<%=i%>"><%=i%></a></li>
                        <% } %>
                        <% if(sonra != pageCount + 1) { %>
                        <li>
                            <a href="index.jsp?p=<%=sonra%>" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                        <% } %>
                    </ul>
                </nav>
            </div>
        </div>
    </body>
</html>
