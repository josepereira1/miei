/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import business.GMS;
import business.Game;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import static web.Index.getSession;

/**
 *
 * @author joaomarques
 */
@WebServlet(name = "AllGames", urlPatterns = {"/AllGames"})
public class AllGames extends HttpServlet {

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
        PersistentSession s = getSession(request);
        GMS gms = GMS.getGMS();
        String navbar = (String) request.getParameter("navbarallgames");
        Object logged = request.getSession().getAttribute("logged");
        if(logged == null || (boolean)logged == false) {  
            request.getRequestDispatcher("/Login").forward(request, response);
        } else if(navbar != null) {
            processNavbar(request,response,navbar);
        } else {
            Collection<Game> games = null;
            try {
                games = gms.allGames(s);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
            request.setAttribute("games",games);
            request.getRequestDispatcher("/WEB-INF/allgames.jsp").forward(request,response);
        }
    }
    
    private void processNavbar(HttpServletRequest request, HttpServletResponse response, String navbar) throws ServletException, IOException {
        switch (navbar) {
            case "My Games":
                request.getRequestDispatcher("/MyGames").forward(request, response);
                break;
            case "Add Game":
                request.getRequestDispatcher("/AddGame").forward(request, response);
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
