/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lorenzoconcas.blog.servlet;

import it.lorenzoconcas.blog.database.*;
import it.lorenzoconcas.blog.objects.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

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

        HttpSession session = request.getSession(false);

        //controllo che l'utente sia loggato e che sia un autore
        if (session != null) {
            //seguiamo gli stessi ragionamenti di Articles.java
            if (session.getAttribute("userID") != null) {
                int id = Integer.parseInt(session.getAttribute("userID").toString());
                int lastID;
                User u = UsersFactory.getIstance().getAuthorByID(id);
                if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true) && u != null) {
                    if (request.getParameter("edit") != null) {
                        id = Integer.parseInt(request.getParameter("edit"));
                        request.setAttribute("currentArticle",  NewsFactory.getIstance().getNewsById(id));
                        request.setAttribute("title", NewsFactory.getIstance().getNewsById(id).getTitle());
                        request.setAttribute("date", NewsFactory.getIstance().getNewsById(id).getDate());
                        request.setAttribute("imageUrl", NewsFactory.getIstance().getNewsById(id).getImageUrl());
                        request.setAttribute("content", NewsFactory.getIstance().getNewsById(id).getContent());
                        session.setAttribute("lastID", id);

                    }
                    //se l'utente chiama la servlet per salvare l'articolo semplicemente prendiamo i dati inseriti
                    else if (request.getParameter("title") != null || request.getParameter("content") != null) {
                        request.setAttribute("title", request.getParameter("title"));
                        request.setAttribute("date", request.getParameter("date"));
                        request.setAttribute("imageUrl", request.getParameter("imageUrl"));
                        request.setAttribute("content", request.getParameter("content"));
                        //ottengo la categoria
                        Map params = request.getParameterMap();
                        String category = "Tutte";
                        for(int i = 0; i < Categories.getIstance().getCategories().size(); i++){
                            if(params.containsKey(Categories.getIstance().getCategories().get(i))){
                                category = Categories.getIstance().getCategories().get(i);
                               
                            }
                        }
                        NewsFactory.getIstance().insertNews
                            (  
                                request.getParameter("title"),
                                request.getParameter("content"),
                                request.getParameter("imageUrl"), 
                                "", 
                                request.getParameter("date"), 
                                category,
                                Integer.parseInt(session.getAttribute("userID").toString()) 
                            );
                        
                        request.setAttribute(category, "on");
                        //calcoliamo l'id da assegnare
                        ArrayList<News> newList = NewsFactory.getIstance().getNewsList();
                        for(int i = 0 ; i< newList.size(); i++){
                            if(newList.get(i).getContent().equals(request.getParameter("title")) && newList.get(i).getContent().equals(request.getParameter("content"))){
                                session.setAttribute("lastID", newList.get(i).getId());
                                
                            }
                        }
                        
                    }
                    request.getRequestDispatcher("NewArticle.jsp").forward(request, response);
                    return;
                }
            }

        }
        //se i requisiti non sono rispettati nego l'accesso

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
