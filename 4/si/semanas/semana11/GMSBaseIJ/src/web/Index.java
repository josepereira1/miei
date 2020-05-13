package web;

import business.GMSFacade;
import data.GameDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

    static final int PAGESIZE = 5;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().setAttribute("logedIn", false);

        request.setAttribute("type", "allGames");

        int maxPages = GMSFacade.numberOfPagesAllGames(PAGESIZE);   //  para já é estático, mas irei fazer uma função que cálcula este valor
        request.setAttribute("maxPages", maxPages);

        Set<Integer> years = GameDAO.getYears();request.setAttribute("years", years);
        Set<String> platforms = GameDAO.getPlatforms();request.setAttribute("platforms", platforms);

        request.setCharacterEncoding("UTF-8");  //  por causa dos caracteres especiais de alguns usernames ou passwords.

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.setAttribute("action", "allGames");

        if(username != null && password != null && GMSFacade.login(username, password)){
            request.getSession().setAttribute("logedIn", true);
            request.getSession().setAttribute("username", username);
        }else{
            request.getSession().setAttribute("logedIn", false);
        }

        request.setAttribute("page", "ListGamesJSON.jsp");
        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/Template.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
