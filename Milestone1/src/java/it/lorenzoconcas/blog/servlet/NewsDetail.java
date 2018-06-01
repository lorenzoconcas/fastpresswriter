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
public class NewsDetail extends HttpServlet {

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

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        int id; //id della notizia
        /*Analizzo la richiesta e cerco il parametro "nid", lo trasformo in seguito in un intero*/
        id = Integer.parseInt(request.getParameter("nid"));
        System.out.println(id);
        //istanzio la Factory delle notizie
        NewsFactory nF = NewsFactory.getIstance();
        /*controllo che il valore inserito sia valido,
            poichè la funzione size() in una lista rende il numero di elementi e la posizione massima in una lista è size-1
            il valore è valido quando minore di size*/
        if (id < nF.getNewsList().size()+1 && id >= 0 && nF.getNewsById(id) != null) {
            
            //Appurato che l'id è valido recuperiamo la notizia desiderata
            News n = nF.getNewsById(id);

            //e anche i commenti, sempre se presenti
            CommentsFactory cF = CommentsFactory.getIstance();
            if (cF.getCommentByNewsID(id).size() > 0) {
                request.setAttribute("comments", cF.getCommentByNewsID(id));
                request.setAttribute("isCommented", true);
            }
            else {
                request.setAttribute("isCommented", false);
            }

            request.setAttribute("author", n.getAuthor());
            request.setAttribute("News", n);

            //chiamo infine la pagina che mostrerà la notizia
            request.getRequestDispatcher("NewsDetail.jsp").forward(request, response);
            return;
        }
        //la notizia non è stata trovata quindi avviso l'utente
        request.setAttribute("errorMessage", "Notizia non trovata");
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
