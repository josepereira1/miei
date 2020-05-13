package web;

import business.GMSFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ListGamesJSON", urlPatterns = {"/ListGamesJSON"})
public class ListGamesJSON extends HttpServlet {

    static final int PAGESIZE = 5;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = (String) request.getParameter("gamesPages");
        String type = (String) request.getParameter("type");

        if(page == null)page = "1";

        PrintWriter pw = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String json = "";
        if(type!= null && type.equals("myGames"))json = GMSFacade.getMyGamesToJSON(Integer.valueOf(page), PAGESIZE);
        else json = GMSFacade.getAllGamesToJSON(Integer.valueOf(page), PAGESIZE);

        pw.print(json);
        pw.flush();
        pw.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
