
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Hello World!</h1>
<div id="liste"></div>
<p id="cnt"></p>
<button id="btn_clear">Temizle</button>
</body>

<script>
    
    
    $("#btn_clear").click(function()
    {
       localStorage.clear();
       location.reload();
    });
    
    $(document).ready(function()
    {
        
        $("#cnt").html('LSta '+localStorage.length+' Deger VAr');
        var v1 = localStorage.getItem("223344");
        var v2 = localStorage.getItem("pc001");
        
        var bg = localStorage.getItem("bg_color");
        $("body").css('background-color', bg);
        
        
        
        for (var i = 0; i < localStorage.length; i++)
        {
            var key = localStorage.key(i);
            
            var val = localStorage.getItem(key);
            console.log('KEY : '+key+" ---> VAL : "+val);
            $("#liste").append("<b>"+key+" : </b> "+val+"<br />");
        }
        
    });
</script>    
</html>
