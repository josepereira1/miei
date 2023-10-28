<%-- 
    Document   : login
    Created on : 24/abr/2020, 22:24:37
    Author     : joaomarques
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Library</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
            }

            td {
                text-align: left;
                padding: 8px;
            }
            
            input[type=submit] {
                background-color: lightgray;
                border: none;
                color: black;
                padding: 10px 25px;
                text-decoration: none;
                margin: 4px 2px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="${pageContext.request.contextPath}\Login">
            <input type="submit" name="navbarlogin" value="Home"/>
        </form>
        <%
            String error = (String) request.getAttribute("error");
            if(error!=null) out.println(error);
        %>
        <form method="POST" action="${pageContext.request.contextPath}\Login">
            <table>
                <tbody>
                    <tr>
                        <td>Name:</td>
                        <td><input required="required" type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input required="required" type="password" name="password"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="actionlogin" value="Login"/>
            <input type="submit" name="actionlogin" value="Register"/>
        </form>
    </body>
</html>
