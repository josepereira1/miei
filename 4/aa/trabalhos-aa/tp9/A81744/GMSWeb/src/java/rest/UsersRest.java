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
import aa.User;
import aa.UserNotExistsException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import org.orm.PersistentException;
import static rest.GamesRest.encodeJSON;
import static rest.GamesRest.getDataFromPost;

/**
 *
 * @author Ricardo Petronilho
 */
@WebServlet(name = "UsersRest", urlPatterns = {"/UsersRest/*"})
public class UsersRest extends HttpServlet {

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
            
            Map<String, Object> data = GamesRest.getDataFromPost(request);                        
            String username = (String) data.get("username");
            String password = (String) data.get("password");
                
            try {             
                IGMS gms = GMS.getGMS();
                if (gms.autenticateUser(username, password)) {
                    User user = gms.getUser(username);
                    response.setContentType("application/json"); 
                    response.getWriter().print(GamesRest.encodeJSON(user)); 
                } 
                else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().print("unauthorized");
                }                        
            } catch (PersistentException e) {
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().print("internal server error");
            } catch (UserNotExistsException e) {
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().print("user does not exist");
            }
            
        }
        
        else { // method == GET
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            response.getWriter().print("method GET not allowed");
        }
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
