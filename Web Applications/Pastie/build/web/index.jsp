<%@page import="java.sql.ResultSet"%>
<%@page import="render.DB"%>
<%@page import="render.Page"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    boolean isLoggedIn = false;
    
    try
    {
        isLoggedIn = session.getAttribute("id") != null;
    } catch (Exception e) { isLoggedIn = false; }
    
    String id = request.getParameter("id");
    
    DB db = new DB();
    ResultSet rs = db.query("select * from shares where id = "+id);
    boolean found = false;
    
    String baslik="", icerik="", tur="", isPublic="", tarih = "";
    
    while (rs.next())
    {
        found = true;
        baslik = rs.getString("baslik");
        icerik = rs.getString("icerik").replace("\n", "<br />");
        tur = rs.getString("tur");
        isPublic = rs.getString("is_public");
        tarih = rs.getString("tarih");
    }
    
    
    if (!found)
    {
        out.println(Page.getHeader("ERROR"));
    }
    else
    {
        out.println(Page.getHeader(baslik+" - "+tarih));
    }
    
    if (isPublic.equals("0"))
    {
        out.println("<center><h1>IT'S SECRET :)</h1></center>");
        return;
    }
    
    if (found) {
%>

<div class='container'>
    <div class='row' style='margin-top:32px'>
        <div class='col-md-12'>
            <div class='col-md-12'>
                <label>Başlık</label>
                <P class='form-control input'><%= baslik+" ("+tur+")" %></P>
            </div>
            
            
        </div>
    </div>
    
    <div class='row' style='margin-top:32px'>
        <div class='col-md-12'>
            <div class='col-md-12'>
            <label>İçerik</label>
            <P class='form-control input' style='min-height: 400px;overflow: auto;overflow-x:hidden'><%= icerik %></P>
            </div>
        </div>
    </div>  
    
    <% if (isLoggedIn) { %>
    <div class='row' style='margin-top:32px'>
        <div class='col-md-12'>
            <div class='col-md-12 text-right'>
                <%=session.getAttribute("ad")%> &nbsp; | &nbsp; <a href='home.jsp'>Kontrol Paneli</a> 
                
            </div>
        </div>
    </div>  
    <% } %>
    
    <% if (!isLoggedIn) { %>
    <div class='row' style='margin-top:32px'>
        <div class='col-md-12'>
            <div class='col-md-12 text-right'>
                <a href='#' data-toggle="modal" data-target="#pwModal">Şifremi Unuttum</a> &nbsp; | &nbsp; 
                <a href='#' data-toggle="modal" data-target="#loginModal">Giriş Yap</a> &nbsp; | &nbsp; 
                <a href='#' data-toggle="modal" data-target="#regModal">Yeni Hesap</a>
            </div>
        </div>
    </div>  
    <% }} %>
</div>





<% if (!isLoggedIn) { %>
<!-- PW MODAL -->
<form  class='modal_form' id='f_pw'>
<input type='hidden' name='servlet' value='srv_pw' />
<div id="pwModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Şifre Hatırlatma</h4>
      </div>
      <div class="modal-body">
          <label>E-Posta Adresiniz</label>
          <input type='email' name='em' class='form-control input' required />
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-danger">Şifremi Hatırlat</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</form>
<!-- PW MODAL -->







<!-- Login MODAL -->
<form  class='modal_form' id='f_login'>
<input type='hidden' name='servlet' value='srv_login' />

<div id="loginModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Giriş Yap</h4>
      </div>
      <div class="modal-body">
          <label>E-Posta Adresiniz</label>
          <input type='email' name='em' class='form-control input' required />
          <br />
          <label>Parolanız</label>
          <input type='password' name='pw' class='form-control input' required />
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-danger">Giriş Yap</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</form>
<!-- Login MODAL -->






<!-- REG MODAL -->
<form  class='modal_form' id='f_reg'>
<input type='hidden' name='servlet' value='srv_reg' />

<div id="regModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-sm">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Yeni Hesap Oluştur</h4>
      </div>
      <div class="modal-body">
          <label>Adınız</label>
          <input type='text' name='ad' class='form-control input' required />
          <br />
          
          <label>E-Posta Adresiniz</label>
          <input type='email' name='em' class='form-control input' required />
          <br />
          
          <label>Parolanız</label>
          <input type='password' name='pw' class='form-control input' required />
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-danger">Kayıt Ol</button>  
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</form>
<!-- REG MODAL -->


<script>
    $('.modal_form').submit(function(e)
    {
        var srv_name = $(this).find("[name='servlet']").val();
        
        e.preventDefault();
        var degerler = $(this).serialize();
        
        $.post("Servlet/"+srv_name, degerler, function(d,s)
        {
           var gelen = $.trim(d);
           
           if (gelen == "login;0")
           {
               alert("Giriş Bilgileri Hatalı");
           }
           
           if (gelen == "login;1")
           {
               location.reload();
           }
           
           if (gelen == "reg;0")
           {
               alert("Kullanıcı Kaydı Oluşturulamadı");
           }
           
           if (gelen == "reg;1")
           {
               alert("Kullanıcı Kaydı Tamamlandı. Lütfen Giriş Yapın");
               $("#regModal").modal('hide');
               
               setTimeout(function()
               {
                   $("#loginModal").modal('show');
               }, 1000);
           }
        });
        
        return false;
    });
    
</script>    
<% } %>
<%    
    out.println(Page.getPageEnd());
%>