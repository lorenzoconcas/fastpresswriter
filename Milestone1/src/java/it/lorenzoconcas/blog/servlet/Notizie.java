/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lorenzoconcas.blog.servlet;

import it.lorenzoconcas.blog.database.*;
import it.lorenzoconcas.blog.objects.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lorec
 */
public class Notizie extends HttpServlet {

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

        HttpSession session = request.getSession();
        UsersFactory uf = UsersFactory.getIstance();
        session.setAttribute("users", uf.getUsers());
        session.setAttribute("authors", uf.getAuthors());
        session.setAttribute("categories", Categories.getIstance().getCategories());
        request.setAttribute("newsList", NewsFactory.getIstance().getNewsByDate(1));//ricordati di mostrarle dalla più vecchia alla più nuova
        //se mi viene chiesto di mostrare le categorie
        if (request.getParameter("category") != null) {

            if (request.getParameter("category").equals("Tutte")) {
                request.setAttribute("newsList", NewsFactory.getIstance().getNewsByDate(1));//ricordati di mostrarle dalla più vecchia alla più nuova
            }
            else {
                request.setAttribute("categorySearchedName", request.getParameter("category"));
                request.setAttribute("newsList", NewsFactory.getIstance().getNewsByCat(request.getParameter("category"), 1));
                //se la categoria è vuota avviso l'utente
                if (NewsFactory.getIstance().getNewsByCat(request.getParameter("category"), 1).size() < 1) {
                    request.setAttribute("emptyCategory", true);
                }
            }
           
        }
        else if (request.getParameter("author") != null) {
            User u = UsersFactory.getIstance().getUserById(Integer.parseInt(request.getParameter("author")));
            request.setAttribute("newsList", NewsFactory.getIstance().getNewsByAuthor(u.getId(), 1));
            request.setAttribute("authorResult", true);
            request.setAttribute("authNameSurname", (u.getName() + " " + u.getSurname()));
            if( NewsFactory.getIstance().getNewsByAuthor(u.getId(), 1).isEmpty())
                request.setAttribute("emptyCategory", true);

        }
        request.getRequestDispatcher("Notizie.jsp").forward(request, response);
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
