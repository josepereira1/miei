<%-- 
    Document   : RegisterUser.jsp
    Created on : Apr 25, 2020, 12:42:06 PM
    Author     : josepereira
--%>

<%@page import="web.RegisterUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register User</h1>
        <form action="${pageContext.request.contextPath}/Register" method="POST">
            <input type="text" name="name"/>
            <input type="text" name="email"/>
            <input type="password" name="password"/>
            <input type="submit" action="registerAction" value="Register"/>
        </form>
    </body>
</html>
