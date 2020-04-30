/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import di.uminho.pt.aa.business.Game;
import di.uminho.pt.aa.business.Platform;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josepereira
 */
@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  CHAPTER 4.2
        
        // O código a seguir serve para reencaminhar objetos para a view, neste caso para o JSP
        Object obj = "hello";
        request.setAttribute("obj", obj);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        
        //  Enviar um jogo para JSP
        /*
            Platform p = new Platform();
        p.setName("PC");
        p.setYear(2013);
        p.setManufacture("Microsoft");
        p.setDescription("Description of the Platform!");
        
        Game g = new Game();
        g.setName("GTA V");
        g.setYear(2012);
        g.setPrice(22);
        g.setDescription("Description of the game!");
        g.setPlatform(p);
        
        request.setAttribute("game", g);
        
        //  CHAPTER 5
        String userAgent = request.getHeader("user-agent");
        request.setAttribute("user-agent", userAgent);
        
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        
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
