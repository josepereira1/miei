/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import business.GMS;
import business.Game;
import business.GameAlreadyExistsException;
import business.GameDontExistException;
import business.MddpPersistentManager;
import business.Platform;
import business.PlatformDontExistException;
import business.UserDontExistException;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddGame", urlPatterns = {"/AddGame"})
public class AddGame extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>POST</code> and <code>GET</code>
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
        String action = (String) request.getParameter("actionaddgame");
        String navbar = (String) request.getParameter("navbaraddgame");
        Object logged = request.getSession().getAttribute("logged");
        List<Platform> platforms = null;
        if(action != null) {
            registerGame(request,response,gms,s);
        } else if(navbar != null) {
            processNavbar(request,response,navbar);
        } else {
            if(logged != null && (boolean)logged) {
                try {
                    platforms = (List) gms.allPlatforms(s);
                    request.setAttribute("platforms", platforms);
                    request.getRequestDispatcher("/WEB-INF/addgame.jsp").forward(request, response);
                } catch (PersistentException e) {
                    e.printStackTrace();
                }
            } else {
                request.getSession().setAttribute("logged", false);
                request.getRequestDispatcher("/Login").forward(request, response);
            }
        }
    }
    
    private void processNavbar(HttpServletRequest request, HttpServletResponse response, String navbar) throws ServletException, IOException {
        switch (navbar) {
            case "My Games":
                request.getRequestDispatcher("/MyGames").forward(request, response);
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
    
    private void registerGame(HttpServletRequest request, HttpServletResponse response, GMS gms, PersistentSession s) throws ServletException, IOException {
        Game game = new Game();
        String username = (String) request.getSession().getAttribute("name");
        try {
            game.setName(request.getParameter("name"));
            game.setYear(Integer.parseInt(request.getParameter("year")));
            game.setPrice(Float.parseFloat(request.getParameter("price")));
            game.setDescription(request.getParameter("description"));
            Platform platform = gms.getPlatformByName(request.getParameter("platform"),s);
            game.setPlatform(platform);
            gms.registerGame(game,s);
            gms.addGameToUser(game.getName(),username,s);
            request.getRequestDispatcher("/MyGames").forward(request, response);
        } catch(NumberFormatException e) {
            request.setAttribute("error","Price need to be numbers");
            request.getRequestDispatcher("/WEB-INF/addgame.jsp").forward(request, response);
            e.printStackTrace();
        } catch(GameAlreadyExistsException e) {
            try {
                gms.addGameToUser(game.getName(), username,s);
                request.getRequestDispatcher("/MyGames").forward(request, response);
            } catch(GameDontExistException | UserDontExistException ex) {
                ex.printStackTrace();
            } catch(PersistentException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } catch(PersistentException | PlatformDontExistException | GameDontExistException | UserDontExistException e) {
            try {
                request.setAttribute("platforms", (List) gms.allPlatforms(s));
            } catch (PersistentException ex) {
                ex.printStackTrace();
            }
            request.setAttribute("error","An error occured");
            request.getRequestDispatcher("/WEB-INF/addgame.jsp").forward(request, response);
            e.printStackTrace();
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
