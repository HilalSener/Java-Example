<%-- 
    Document   : test
    Created on : 12.Tem.2017, 09:12:54
    Author     : EmirCivas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <%
        for (int i = 0; i<100; i++)
        {
            %>
<div id="div_<%=i %>"style="border:1px dashed red;padding:30px;margin:30px;">
    <h1>BAŞLIK <%=i %></h1>
    <hr />
    <p>İÇERİK <%=i %></p>
</div>
            <%
        }
        
        %>
</body>
</html>
