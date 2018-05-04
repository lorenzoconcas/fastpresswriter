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

/**
 * 
 * @author lorec
 */
public class Search extends HttpServlet {

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
           
           if(request.getParameter("query") != null ){
               request.setAttribute("searched", true); //se la pagina è stata chiamata con una query
            
               String query = request.getParameter("query");
               boolean foundNewsBool = false;
                boolean foundInNewsBool = false;
               //ora cerco i titoli degli articoli
               
               NewsFactory nF = NewsFactory.getIstance();
               ArrayList<News> notizie = nF.getNewsList();
               ArrayList<News> foundNews = new ArrayList<>();
               ArrayList<News> foundInNews = new ArrayList<>();
               //cerco la query nei titoli
               int tAFound = 0;
               for(News n : notizie){
                   if(n.getTitle().contains(query)){
                       foundNews.add(n);
                       foundNewsBool = true;
                      tAFound++;
                   }
               }
               //cerco la query nei contenuti
                int tATFound = 0;
                for(News n : notizie){
                   if(n.getContent().contains(query)){
                       foundInNews.add(n);
                       foundInNewsBool = true;
                       tATFound++;
                      
                   }
               }
                //cerco la query nei nomi utente
                int tAuthFound = 0;
                Boolean foundUsrBool = false;
                ArrayList<User> foundUsr = new ArrayList<>();
                for(User u : UsersFactory.getIstance().getUsers()){
                   if(u.getName().contains(query) || u.getSurname().contains(query) || u.getUsername().contains(query)){
                       foundUsr.add(u);
                       foundUsrBool = true;
                       tAuthFound++;
                       
                   }
               }
                request.setAttribute("tAuthFound", tAuthFound);
                
                request.setAttribute("tAFound", tAFound);
                request.setAttribute("tATFound", tATFound);
                   
                request.setAttribute("foundNewsBool", foundNewsBool);
                request.setAttribute("foundInNewsBool", foundInNewsBool);
                request.setAttribute("foundNews", foundNews); 
                request.setAttribute("foundInNews", foundInNews); 
                
                request.setAttribute("query", query);
             
                request.setAttribute("foundUsrList", foundUsr);
                request.setAttribute("foundUsrBool", foundUsrBool);
                
           }
           else{
                
                request.setAttribute("searched", false);
                //request.getRequestDispatcher("search.jsp").forward(request, response);
           }
           request.getRequestDispatcher("Search.jsp").forward(request, response);
            
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
