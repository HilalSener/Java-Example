<%-- 
    Document   : index
    Created on : 12.Tem.2017, 08:47:02
    Author     : EmirCivas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <form id="cartAddForm">
        <label>Item Id</label><br />
        <input type="text" name="item_id" id="item_id" /><br />
        <label>Item QTY</label><br />
        <input type="text" name="item_qty" id="item_qty" /><br />
        <br />
        <input type="submit" value="Sepete Ekle" />
    </form>
<script>
    $("#cartAddForm").submit(function(e)
    {
        e.preventDefault();
        var item_id = $("#item_id").val();
        var item_qty= $("#item_qty").val();
        
        localStorage.setItem(item_id, item_qty);
        return true;
    });
</script>
</body>
</html>
