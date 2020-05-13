package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddGame", urlPatterns = {"/AddGame"}  )
public class AddGame extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //  as duas linhas seguintes servem para impedir o user de aceder aos controllers pelo link quando não está logado
        Boolean logedIn = (Boolean) request.getSession().getAttribute("logedIn");
        if(logedIn == false) getServletConfig().getServletContext()
                .getRequestDispatcher("/Index").forward(request,response);

        //  Nota importante:
        //  não foi implementada a lógica de adicionar o jogo, visto que os dados são estáticos e o professor não pediu o mesmo no enucniado

        request.setAttribute("page", "AddGame.jsp");
        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/Template.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
