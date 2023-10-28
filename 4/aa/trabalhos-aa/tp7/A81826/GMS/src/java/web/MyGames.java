/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import business.GMS;
import business.Game;
import business.MddpPersistentManager;
import business.UserDontExistException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author joaomarques
 */
@WebServlet(name = "MyGames", urlPatterns = {"/MyGames"})
public class MyGames extends HttpServlet {

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
        PersistentSession s = Index.getSession(request);
        GMS gms = GMS.getGMS();
        Object logged = request.getSession().getAttribute("logged");
        String navbar = (String) request.getParameter("navbarmygames");
        if(navbar != null) {
            processNavbar(request,response,navbar);
        } else if(logged != null) {
            if((boolean)logged) {
                try {
                    String username = (String)request.getSession().getAttribute("name");
                    Collection<Game> games = gms.getGamesByUser(username,s);
                    request.setAttribute("games", games);
                    request.getRequestDispatcher("/WEB-INF/mygames.jsp").forward(request,response);
                } catch (UserDontExistException | PersistentException e) {
                    e.printStackTrace();
                }
            } else {
                request.getRequestDispatcher("/Login").forward(request, response);
            }
        } else {
            request.getSession().setAttribute("logged",false);
            request.getRequestDispatcher("/Login").forward(request, response);
        }
    }
    
    private void processNavbar(HttpServletRequest request, HttpServletResponse response, String navbar) throws ServletException, IOException {
        switch (navbar) {
            case "Add Game":
                request.getRequestDispatcher("/AddGame").forward(request, response);
                break;
            case "All Games":
                request.getRequestDispatcher("/AllGames").forward(request, response);
                break;
            case "Search Game":
                request.getRequestDispatcher("/SearchGame").forward(request, response);
                break;
            case "Logout":
                request.getSession().setAttribute("logged", false);
                request.getSession().setAttribute("name", null);
                request.getRequestDispatcher("/Index").forward(request, response);
                break;
            default:
                break;
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
