<%@page import="render.Page"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    if (!isLoggedIn)
    {
        response.sendRedirect("login.jsp");
    }
    
%>    
<% out.println(Page.getHeader("Yeni İçerik Ekle"));  %>

<div class="container">
    <form id="ekleForm">
    <div class="row" style="margin-top:18px">
        <div class="col-md-8">
            <label>Paylaşım Adı</label>
            <input name="ad" type="text" class="form-control input" required placeholder="Paylaşım Adınız Giriniz" />
        </div>
        
        <div class="col-md-2">
            <label>Paylaşım Türü</label>
            <select name="tur" class="form-control input" required>
                <option value="">Seçiniz</option>
                <option value="txt">Düz Metin</option>
                <option value="java">Java</option>
                <option value="js">JavaScript</option>
                <option value="php">PHP</option>
                
            </select>
        </div>
        
        <div class="col-md-2">
            <label>Herkese Açık Mı</label>
            <select name="public" class="form-control input" required>
                <option value="">Seçiniz</option>
                <option value="1">Evet</option>
                <option value="0">Hayır</option>
            </select>
        </div>
    </div>
    
    <div class="row" style="margin-top:18px">
        <div class="col-md-12">
            <label>Paylaşılacak İçerik</label>
            <textarea name="content" class="form-control input" required placeholder="İçeriği Buraya Yazın" style="height: 400px"></textarea>
        </div>
    </div>
    
    <div class="row" style="margin-top:18px">
        <div class="col-md-12 text-right">
        <button type="submit" class="btn btn-lg btn-success">Paylaş</button>
        </div>
    </div>
</form>
</div>

<script>
$("#ekleForm").submit(function(e)
{
    e.preventDefault();
    var degerler = $(this).serialize();
    alert(degerler);
    
    $.post("Servlet/srv_ekle", degerler, function(d,s)
    {
        var sonuc = $.trim(d);
        
        location.href="http://localhost:8080/Pastie/"+sonuc;
    });
    return false;
});    
    
</script>

<% out.println(Page.getPageEnd()); %>