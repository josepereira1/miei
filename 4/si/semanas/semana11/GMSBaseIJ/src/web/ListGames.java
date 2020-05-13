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
        //  process request without JSON (o que foi feito inicialmente, dessa forma separei em dois métodos para aproveitar a classe)
        //  importa lembrar que neste método não está feito o my games, pois nessa fase do tutorial ainda não tinha sido pedido
        //processRequestWithoutJSON(request, response);

        //  process request with data from json using AJAX
        processRequestWithJSON(request, response);
    }

    protected void processRequestWithoutJSON(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //  as duas linhas seguintes servem para impedir o user de aceder aos controllers pelo link quando não está logado
        Boolean logedIn = (Boolean) request.getSession().getAttribute("logedIn");
        if(logedIn == false) getServletConfig().getServletContext()
                .getRequestDispatcher("/Index").forward(request,response);

        String username = "José Pereira";
        request.setAttribute("username", username);

        int maxPages = GMSFacade.numberOfPagesAllGames(PAGESIZE);   //  para já é estático, mas irei fazer uma função que cálcula este valor
        request.setAttribute("maxPages", maxPages);

        Set<Integer> years = GameDAO.getYears();request.setAttribute("years", years);
        Set<String> platforms = GameDAO.getPlatforms();request.setAttribute("platforms", platforms);

        String page = (String) request.getParameter("gamesPages");  //  para saber a página selecionada

        List<Game> list = null;

        if(page == null) list = GMSFacade.getAllGamesPage(0, PAGESIZE);  //  primeiro acesso à página
        else list = GMSFacade.getAllGamesPage(Integer.valueOf(page)-1, PAGESIZE);    //  as diferentes páginas

        request.setAttribute("games", list);

        request.setAttribute("page", "ListGames.jsp");

        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/Template.jsp").forward(request,response);
    }

    protected void processRequestWithJSON(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = "José Pereira";
        request.setAttribute("username", username);

        Set<Integer> years = GameDAO.getYears();
        request.setAttribute("years", years);
        Set<String> platforms = GameDAO.getPlatforms();
        request.setAttribute("platforms", platforms);

        String action = request.getParameter("action");

        int maxPages;

        if(action != null && action.equals("myGames")) {
            request.setAttribute("addButton", "addButton");
            maxPages = GMSFacade.numberOfPagesMyGames(PAGESIZE);    //  determinar o número de páginas para listar o my games
        }else maxPages = GMSFacade.numberOfPagesAllGames(PAGESIZE);   //  determinar o número de páginas para listar o all games

        request.setAttribute("maxPages", maxPages);

        request.setAttribute("action", action);
        request.setAttribute("page", "ListGamesJSON.jsp");
        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/Template.jsp").forward(request, response);
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
