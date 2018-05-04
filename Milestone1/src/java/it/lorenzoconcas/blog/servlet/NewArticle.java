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
public class NewArticle extends HttpServlet {

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

            HttpSession session = request.getSession();
            //seguiamo gli stessi ragionamenti di Articles.java
            int id = Integer.parseInt(session.getAttribute("userID").toString());
            User u = Authors.getIstance().getAuthorByID(id);
            out.println("2");
            if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true) && u != null) {
                //se l'utente chiama la servlet per salvare l'articolo semplicemente prendiamo i dati inseriti
                if (request.getParameter("title") != null || request.getParameter("content") != null) {
                    request.setAttribute("title", request.getParameter("title"));
                    request.setAttribute("date", request.getParameter("date"));
                    request.setAttribute("imageUrl", request.getParameter("imageUrl"));
                    request.setAttribute("content", request.getParameter("content"));
                    //calcoliamo l'id da assegnare
                    int lastID;
                    if (session.getAttribute("lastID") == null) {

                        //poichè gli id sono assegnati progressivamente, l'ultimo ID sarà:
                        //dimensione lista news -1 
                        lastID = NewsFactory.getIstance().getNewsList().size() - 1;
                        lastID++;
                       
                    }
                    else {
                        lastID = Integer.parseInt(session.getAttribute("lastID").toString());
                        lastID++;
                    }
                    session.setAttribute("lastID", lastID);

                }
                request.getRequestDispatcher("NewArticle.jsp").forward(request, response);

            }
            //se i requisiti non sono rispettati nego l'accesso
            else {

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