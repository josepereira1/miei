/*
 * ListGames
 * ruicouto in 10/abr/2017
 */
package web;

import business.GMSFacade;
import business.Game;
import data.GameDAO;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ruicouto
 */
@WebServlet(name = "ListGames", urlPatterns = {"/ListGames"})
public class ListGames extends HttpServlet {

    private static final int PAGESIZE = 5;

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
        response.setContentType("text/html;charset=UTF-8");

        String username = "José Pereira";
        request.setAttribute("username", username);

        int maxPages = GameDAO.getNumberPages(PAGESIZE);   //  para já é estático, mas irei fazer uma função que cálcula este valor
        request.setAttribute("maxPages", maxPages);

        Set<Integer> years = GameDAO.getYears();request.setAttribute("years", years);
        Set<String> platforms = GameDAO.getPlatforms();request.setAttribute("platforms", platforms);

        String page = (String) request.getParameter("gamesPages");  //  para saber a página selecionada

        List<Game> list = null;

        if(page == null) list = GMSFacade.getGamesOfPage(0, PAGESIZE);  //  primeiro acesso à página
        else list = GMSFacade.getGamesOfPage(Integer.valueOf(page)-1, PAGESIZE);    //  as diferentes páginas



        request.setAttribute("games", list);

        request.setAttribute("page", "ListGames.jsp");

        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/Template.jsp").forward(request,response);
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
