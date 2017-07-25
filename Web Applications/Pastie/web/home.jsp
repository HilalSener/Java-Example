<%@page import="java.sql.ResultSet"%>
<%@page import="render.DB"%>
<%@page import="render.Page"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% out.println(Page.getHeader("Kontrol Paneli"));  %>

<%
    
    boolean isLoggedIn = false;
    
    try
    {
        isLoggedIn = session.getAttribute("id") != null;
    } catch (Exception e) 
    {
        response.sendRedirect("login.jsp");
        isLoggedIn = false; 
    }
    
    
    if (isLoggedIn)
    {
        %>
        
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/jszip-3.1.3/pdfmake-0.1.27/dt-1.10.15/b-1.3.1/b-flash-1.3.1/b-html5-1.3.1/b-print-1.3.1/r-2.1.1/sc-1.4.2/se-1.2.2/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs/jszip-3.1.3/pdfmake-0.1.27/dt-1.10.15/b-1.3.1/b-flash-1.3.1/b-html5-1.3.1/b-print-1.3.1/r-2.1.1/sc-1.4.2/se-1.2.2/datatables.min.js"></script>

        <div class='container'>
            <div class='col-md-12' style="margin-top:100px">
                <table id="tbl" class='table table-bordered table-striped table-hover' width='100%'>
                    <thead>
                        <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">TARİH</th>
                        <th class="text-center">BAŞLIK</th>
                        <th class="text-center">TÜR</th>
                        <th class="text-center">HERKESE AÇIK MI</th>
                        <th class="text-center">İŞLEM</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            DB db = new DB();
                            String sql = "select id, DATE_FORMAT(tarih,'%d.%m.%Y %H:%i:%S') as 'tarih', baslik, tur, is_public from shares where user_id = "+session.getAttribute("id");
                            ResultSet rs = db.query(sql);
                            while (rs.next())
                            {
                                String id = rs.getString(1);
                                String link = "<a href='http://localhost:8080/Pastie/"+id+"' target='_blank'>"+id+"</a>";
                                %>
                                <tr>
                                    <td style="vertical-align:middle" align='center'><%=link %></td>
                                    <td style="vertical-align:middle" align='center'><%=rs.getString(2)%></td>
                                    <td style="vertical-align:middle" align='center'><%=rs.getString(3)%></td>
                                    <td style="vertical-align:middle" align='center'><%=rs.getString(4)%></td>
                                    <td style="vertical-align:middle" align='center'><%=rs.getString(5).equals("1") ? "Evet":"Hayır" %></td>
                                    <td style="vertical-align:middle" align='center'>
                                        <div class="dropdown">
                                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                              Seçin
                                              <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                                              <li><a class="share_sil" share_id="<%=id %>" href="#">Sil</a></li>
                                              <li role="separator" class="divider"></li>
                                              <li><a  class="share_upd" share_id="<%=id %>" href="#">Değiştir</a></li>
                                            </ul>
                                      </div>
                                    </td>
                                </tr>
                                <%
                            }
                        %>
                    </tbody>
                
                </table>
                    <br />
                    <div align="right">
                        <a href="ekle.jsp" class="btn btn-danger">Yeni İçerik Ekle</a>
                    </div>
            </div>
        </div>
                    
                    
        
        <script>
            $(".share_sil").click(function()
            {
                var id = $(this).attr("share_id");
                var sonuc = window.confirm("ID Değeri \""+id+"\" Olan Paylaşımı Silmek İstediğinize Emin Misiniz ?");
                if (sonuc)
                {
                   $.post("Servlet/srv_share", {"islem" : "sil", "share_id" : id}, function(d,s)
                    {
                       location.reload(); 
                    }); 
                }
                
            });
            
            $(".share_upd").click(function()
            {
                var id = $(this).attr("share_id");
                $.post("Servlet/srv_share", {"islem" : "upd", "share_id" : id}, function(d,s)
                {
                    location.reload(); 
                });
            });
            
            $(document).ready(function() 
            {
                /*
                $('#tbl').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    });*/
        
        $('#tbl').DataTable();
            } );
        </script>
        <%
    }
    
    else
    {
        response.sendRedirect("login.jsp");

    }


out.println(Page.getPageEnd());
%>
