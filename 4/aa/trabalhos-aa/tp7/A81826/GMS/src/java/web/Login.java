/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import business.Checksum;
import business.GMS;
import business.MddpPersistentManager;
import business.User;
import business.UserDontExistException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for HTTP <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void responsePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersistentSession s = Index.getSession(request);
        GMS gms = GMS.getGMS();
        String action = (String) request.getParameter("actionlogin");
        String navbar = (String) request.getParameter("navbarlogin");
        if(action != null) {
            if(action.equals("Register")) {
                request.getRequestDispatcher("/Register").forward(request, response);
            } else {
                login(request,response,gms,s);
            }
        } else if(navbar != null) {
            request.getRequestDispatcher("/Index").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
    
    /**
     * Processes requests for HTTP <code>GET</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void responseGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersistentSession s = Index.getSession(request);
        GMS gms = GMS.getGMS();
        Object logged = request.getSession().getAttribute("logged");
        if(logged != null) {
            if((boolean)logged) {
                request.getRequestDispatcher("/MyGames").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.getSession().setAttribute("logged",false);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response, GMS gms, PersistentSession s) throws ServletException, IOException {
        User u = null;
        try {
            u = gms.getUserByName(request.getParameter("name"),s);
        } catch(PersistentException e) {
            request.getSession().setAttribute("logged", false);
            request.setAttribute("error", "An error occured");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            e.printStackTrace();
        } catch(UserDontExistException e) {
            request.getSession().setAttribute("logged", false);
            request.setAttribute("error", "Invalid credentials");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            e.printStackTrace();
        }
        if(u != null) {
            try {
                if(u.getPassword().equals(Checksum.getFileChecksum(request.getParameter("password").getBytes(),MessageDigest.getInstance("sha-256")))) {
                    request.getSession().setAttribute("logged", true);
                    request.getSession().setAttribute("name",u.getName());
                    request.getRequestDispatcher("/MyGames").forward(request, response);
                } else {
                    request.getSession().setAttribute("logged", false);
                    request.setAttribute("error", "Invalid credentials");
                    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                }
            } catch(NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
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
        responseGet(request, response);
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
        responsePost(request, response);
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
