<%-- 
    Document   : index.jsp
    Created on : Apr 24, 2020, 5:26:30 PM
    Author     : josepereira
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
            //  Aqui estamos a buscar o atribute enviado pelo controller, e a colocar uppercase
            String param = request.getAttribute("obj").toString().toUpperCase();
            out.println(param);
        %>
        
        <%--<% 
            String game = request.getAttribute("game").toString();
            out.println(game);
        %> --%>
        
        <% 
            String userAgent = request.getAttribute("user-agent").toString();
            out.println(userAgent);
        %>
    </body>
</html>
