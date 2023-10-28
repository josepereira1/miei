/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import aa.GMS;
import aa.Game;
import aa.GameNotExistsException;
import aa.IGMS;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.orm.PersistentException;

/**
 *
 * @author Ricardo Petronilho
 */
@WebServlet(name = "GamesRest", urlPatterns = {"/GamesRest/*"})
public class GamesRest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] url = request.getRequestURI().toString().split("/");
        String target = url[url.length-1];
        String method = request.getMethod();
        
        // request info
        System.out.println(Arrays.toString(url));
        System.out.println(target);
        System.out.println(method);
        
        if(method.equals("POST")) {
            
            Map<String, Object> data = getDataFromPost(request); 
            IGMS gms = GMS.getGMS();
            try {
                Game game = gms.getGame((String)data.get("gamename"));
                response.setContentType("application/json"); // indicar que o conteúdo é json
                response.getWriter().print(encodeJSON(game)); // escrever diretamente o json em vez de encaminhar para a página
            } catch (PersistentException e) {
                e.printStackTrace();
                response.setStatus(Status.INTERNAL_SERVER_ERROR.getStatusCode());
                response.getWriter().print("internal server error"); // escrever diretamente o json em vez de encaminhar para a página
            } catch (GameNotExistsException e) {
                e.printStackTrace();
                response.setStatus(Status.NOT_FOUND.getStatusCode());
                response.getWriter().print("game not found"); // escrever diretamente o json em vez de encaminhar para a página
            }
            
        } 
        
        else { // method == GET
            
            IGMS gms = GMS.getGMS();
            try {
                Collection<Game> games = gms.getAllGames();
                response.setContentType("application/json"); // indicar que o conteúdo é json
                response.getWriter().print(encodeJSON(games)); // escrever diretamente o json em vez de encaminhar para a página
            } catch (PersistentException e) {
                e.printStackTrace();
                response.setStatus(Status.INTERNAL_SERVER_ERROR.getStatusCode());
                response.getWriter().print("internal server error"); // escrever diretamente o json em vez de encaminhar para a página
            }
            
        }
        
        
    }
    
    public static Map<String, Object> getDataFromPost(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = request.getReader().readLine()) != null) {
            sb.append(line);
        }
        return new ObjectMapper().readValue(sb.toString(), Map.class);     
    }
    
    public static String encodeJSON(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
