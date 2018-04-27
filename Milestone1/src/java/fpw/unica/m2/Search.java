/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.unica.m2;

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
               
               NotizieFactory nF = NotizieFactory.getIstance();
               ArrayList<Notizia> notizie = nF.getNewsList();
               ArrayList<Notizia> foundNews = new ArrayList<>();
               ArrayList<Notizia> foundInNews = new ArrayList<>();
               
               for(Notizia n : notizie){
                   if(n.getTitolo().contains(query)){
                       foundNews.add(n);
                       foundNewsBool = true;
                      
                   }
               }
               
                for(Notizia n : notizie){
                   if(n.getContent().contains(query)){
                       foundInNews.add(n);
                       foundInNewsBool = true;
                      
                   }
               }
               request.setAttribute("query", query);
               request.setAttribute("foundNewsBool", foundNewsBool);
                request.setAttribute("foundInNewsBool", foundInNewsBool);
               if(foundNewsBool)                
                    request.setAttribute("foundNews", foundNews);                   
  
               if(foundInNewsBool)
                   request.setAttribute("foundInNews", foundInNews);       
           }
           else{
                
                request.setAttribute("searched", false);
                //request.getRequestDispatcher("search.jsp").forward(request, response);
           }
           request.getRequestDispatcher("search.jsp").forward(request, response);
            
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
