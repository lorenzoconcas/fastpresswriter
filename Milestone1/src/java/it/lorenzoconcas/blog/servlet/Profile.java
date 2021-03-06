/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lorenzoconcas.blog.servlet;

import it.lorenzoconcas.blog.database.*;
import it.lorenzoconcas.blog.objects.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lorec
 */
public class Profile extends HttpServlet {

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

        HttpSession session = request.getSession(false);
        //controllo che l'utente sia loggato e che sia un autore
        if (session != null && session.getAttribute("userID") != null) {
            //seguiamo gli stessi ragionamenti di Articles.java
            
            int id = Integer.parseInt(session.getAttribute("userID").toString());
            User u = UsersFactory.getIstance().getUserById(id);
            //è necessario solo che sia loggato, non serve essere anche autori
            if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) {
                if(request.getParameter("deleteUser") != null && true){                    
                    UsersFactory.getIstance().deleteUser(u.getId());
                   request.getRequestDispatcher("login.html?logout=true").forward(request, response);
                }
                request.getRequestDispatcher("Profile.jsp").forward(request, response);
                return;
            }
        } //se i requisiti non sono rispettati nego l'accesso
        
        request.setAttribute("errorMessage", "Spiacenti, accesso negato");
        request.getRequestDispatcher("notAllowed.jsp").forward(request, response);
        
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
