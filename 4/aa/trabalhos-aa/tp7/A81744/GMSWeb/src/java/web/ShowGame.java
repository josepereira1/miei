/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import aa.GMS;
import aa.Game;
import aa.GameNotExistsException;
import aa.IGMS;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.orm.PersistentException;

/**
 *
 * @author Ricardo Petronilho
 */
@WebServlet(name = "ShowGame", urlPatterns = {"/ShowGame"})
public class ShowGame extends HttpServlet {

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
        
        // por questões de segurança caso não tenha feito Login encaminhar para o Login
        Boolean loggedIn = (Boolean) request.getSession().getAttribute("loggedIn");
        if (loggedIn == null || loggedIn == false) request.getRequestDispatcher("/Login").forward(request, response);
        
        String action = request.getParameter("showGameAction");   
        
        // method = GET, simplesmente apresenta a página sem jogo
        if (action == null) request.getRequestDispatcher("/WEB-INF/showGame.jsp").forward(request, response);
        
        // para não haver problemas caso tenha introduzido a "action" com maiúsculas sem querer
        action = action.toLowerCase();
        
        // clicou no botão "Search" por isso apresenta a página com a informação do jogo
        if (action.equals("search")) displayGame(request, response);
        
        // clicou no botão "Add Game" por isso encaminha para o Controller responsável
        if (action.equals("addgame"))  request.getRequestDispatcher("/AddGame").forward(request, response);
        
        // clicou no botão "My Game" por isso encaminha para o Controller responsável
        else if (action.equals("usergames")) request.getRequestDispatcher("/MyGames").forward(request, response);
        
        // clicou no botão "All Game" por isso encaminha para o Controller responsável
        else if (action.equals("allgames")) request.getRequestDispatcher("/AllGames").forward(request, response);
        
        // internal error (não é suposto entrar aqui)
        else request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
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

    private void displayGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
        
        // obtém o nome do jogo introduzido pelo cliente no form
        String gameName = request.getParameter("gamename");
        
        int warningType = -1; // para saber que aviso informo ao cliente
        // 0 - não introduziu todos os campos
        // 1 - jogo introduzido não existe

        if (gameName != null && gameName.isEmpty() == false) {
        
            IGMS gms = GMS.getGMS();
            try {
                Game game = gms.getGame(gameName, Login.getPersistentSession(request));
                request.setAttribute("game", game);
                request.getRequestDispatcher("/WEB-INF/showGame.jsp").forward(request, response);
            } catch (PersistentException e) {
                e.printStackTrace();
                request.getRequestDispatcher("/WEB-INF/internalError.jsp").forward(request, response);
            } catch (GameNotExistsException e) {
                e.printStackTrace();
                warningType = 1;  // jogo introduzido não existe
            }
        } 
        
        else warningType = 0; // não introduziu todos os campos
          
        request.setAttribute("warningType", warningType);      
        request.getRequestDispatcher("/WEB-INF/showGame.jsp").forward(request, response);
    }
}
