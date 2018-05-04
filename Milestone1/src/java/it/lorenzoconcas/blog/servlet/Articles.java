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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lorec
 */
public class Articles extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            //Questa servelt mostra solo agli autori la lista dei proprio articoli
            //chi non è autore viene respinto con un accesso negato
            //per ora la lista degli autori viene calcolata semplicemente controllando articolo per articolo quali sono gli autori

            HttpSession session = request.getSession();
            //controllo che l'utente sia loggato e che sia un autore
            int id = Integer.parseInt(session.getAttribute("userID").toString());
            User u = Authors.getIstance().getAuthorByID(id);
            //poichè la funzione getAuthorByID restituisce null se l'utente richiesto non è un autore
            //aggiungiamo alle verifiche di login anche quella di essere un autore valido
            if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true) && u != null) {
                //carico gli articoli dell'autore in una lista e la setto come attributo di request
                ArrayList<News> newsList = NewsFactory.getIstance().getNewsByAuthor(u);
                request.setAttribute("authorNewsList", newsList);
                request.getRequestDispatcher("Articles.jsp").forward(request, response);
            }
            //se i requisiti non sono rispettati nego l'accesso
            else{
                request.setAttribute("errorMessage", "Spiacenti, accesso negato");
                request.getRequestDispatcher("notAllowed.jsp").forward(request, response);
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
