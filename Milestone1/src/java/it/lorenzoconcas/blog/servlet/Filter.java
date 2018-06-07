/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lorenzoconcas.blog.servlet;

import it.lorenzoconcas.blog.database.Categories;
import it.lorenzoconcas.blog.database.NewsFactory;
import it.lorenzoconcas.blog.database.UsersFactory;
import it.lorenzoconcas.blog.objects.News;
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
public class Filter extends HttpServlet {

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
      
        
        String command = request.getParameter("cmd");
        
        if(command != null){
            switch(command){
                case "search":{
                    String query_string = request.getParameter("q"); 
                    ArrayList<News> all_news = NewsFactory.getIstance().searchNews(query_string);                   
                    request.setAttribute("newsList", all_news);    
                      response.setContentType("application/json");
                    response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate"); 
                    request.getRequestDispatcher("res/JSONResults/FilteredNewsJSON.jsp").forward(request, response);
                    break;
                }
                case "getCat":{
                    if(request.getParameter("q")!= null)
                        request.setAttribute("categories", Categories.getIstance().getCategories(request.getParameter("q")));
                    else
                         request.setAttribute("categories", Categories.getIstance().getCategories());                    
                    request.getRequestDispatcher("res/JSONResults/CatJSON.jsp").forward(request, response);
                    break;
                }
                case "getAuths":{
                   if(request.getParameter("q")!= null)
                       request.setAttribute("authors", UsersFactory.getIstance().getAuthors(request.getParameter("q")));
                     
                    else
                         request.setAttribute("authors", UsersFactory.getIstance().getAuthors());
                    
                    request.getRequestDispatcher("res/JSONResults/AuthJSON.jsp").forward(request, response);
                    break;
                }
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
