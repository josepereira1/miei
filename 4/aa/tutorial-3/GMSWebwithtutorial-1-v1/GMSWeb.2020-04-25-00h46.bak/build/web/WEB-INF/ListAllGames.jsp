<%-- 
    Document   : ListGames.jsp
    Created on : Apr 24, 2020, 11:56:36 PM
    Author     : josepereira
--%>

<%@page import="java.util.List"%>
<%@page import="pt.uminho.di.aa.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Games</h1>
        <ul>
            <%-- <% List<Game> games = (List) request.getAttribute("games");
               for(Game g : games) { %>
                    <li> <%= g.getName() %></li>
             <% } %> --%>
        </ul>
        
        <table>
            <tr>
                <th>Nome</th>
                <th>Platform</th>
                <th>Year</th>
                <th>Price</th>
                <th>Description</th>
            </tr>
            
            <% List<Game> games = (List) request.getAttribute("games");
                for(Game g : games) { %>
                <tr>
                    <td><%= g.getName() %></td>
                    <td><%= g.getPlatform() %></td>
                    <td><%= g.getYear() %></td>
                    <td><%= g.getPrice() %></td>
                    <td><%= g.getDescription() %></td>
                </tr>    
             <% } %>
            
        </table>
    </body>
</html>
