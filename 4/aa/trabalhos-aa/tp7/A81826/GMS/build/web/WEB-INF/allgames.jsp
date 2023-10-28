<%-- 
    Document   : allgames
    Created on : 26/abr/2020, 15:06:04
    Author     : joaomarques
--%>

<%@page import="java.util.List"%>
<%@page import="business.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            
            tr:hover {
                background-color: #dddddd;
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
            
            input[type="submit"]:disabled {
                background: #f5f5f5;
                color: lightgray;
            }
        </style>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="POST" action="${pageContext.request.contextPath}\AllGames">
            <input type="submit" name="navbarallgames" value="All Games" disabled="disabled"/>
            <input type="submit" name="navbarallgames" value="My Games"/>
            <input type="submit" name="navbarallgames" value="Add Game"/>
            <input type="submit" name="navbarallgames" value="Search Game"/>
            <input type="submit" name="navbarallgames" value="Logout"/>
        </form>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Platform</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <% List<Game> games = (List) request.getAttribute("games");
                for(Game g : games) { %>
                    <tr>
                        <td><%= g.getName() %></td>
                        <td><%= g.getYear() %></td>
                        <td><%= g.getPrice() %></td>
                        <td><%= g.getPlatform().getName() %></td>
                        <td><%= g.getDescription() %></td>
                    </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
