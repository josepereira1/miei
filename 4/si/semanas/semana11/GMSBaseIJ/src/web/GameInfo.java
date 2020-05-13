package web;

import business.GMSFacade;
import business.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "GameInfo", urlPatterns = {"/GameInfo"})
public class GameInfo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  as duas linhas seguintes servem para impedir o user de aceder aos controllers pelo link quando não está logado
        Boolean logedIn = (Boolean) request.getSession().getAttribute("logedIn");
        if(logedIn == false) getServletConfig().getServletContext()
                .getRequestDispatcher("/Index").forward(request,response);

        String gameName = request.getParameter("gameName");

        Game g = GMSFacade.getGame(gameName);
        if(g != null) {
            request.setAttribute("name", g.getName());
            request.setAttribute("year", g.getYear());
            request.setAttribute("description", g.getDescription());
        }
        request.setAttribute("page", "GameInfo.jsp");

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
