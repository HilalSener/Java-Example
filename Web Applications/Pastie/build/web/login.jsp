<%-- 
    Document   : login
    Created on : 10.Tem.2017, 11:41:43
    Author     : EmirCivas
--%>

<%@page import="render.Page"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% out.println(Page.getHeader("Giriş Yap")); %>

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


<script>
    
    $(document).ready(function()
    {
        $("#loginModal").modal('show');
    });
    
    
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
               location.href="home.jsp";
           }
           
           
        });
        
        return false;
    });
    
    $('#loginModal').on('hidden.bs.modal', function () {
        $('#loginModal').modal('show');
})
</script>    
<% out.println(Page.getPageEnd()); %>
