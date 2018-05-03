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
import javax.servlet.http.HttpSession;

/**
 *
 * @author lorec
 */
public class FindBy extends HttpServlet {

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
            
            if (request.getParameter("category") != null) {
                if(NotizieFactory.getIstance().getNewsByCat((String) request.getParameter("category")).size() > 0){
                    request.setAttribute("listaNews", NotizieFactory.getIstance().getNewsByCat((String) request.getParameter("category")));
                    request.getRequestDispatcher("personalArticles.jsp").forward(request, response);
                }
                else request.getRequestDispatcher("NotFound.jsp").forward(request, response);
            }
            //mostro per id autore, la userò prossimamente
            else if (request.getParameter("authorID") != null){
                if(UtentiFactory.getIstance().getUsers().size() > Integer.parseInt((String) request.getParameter("authorID"))){
                    request.setAttribute("listaNews", NotizieFactory.getIstance().getNewsByAuthor(UtentiFactory.getIstance().getUserById(Integer.parseInt((String) request.getParameter("authorID")))));
                    request.getRequestDispatcher("personalArticles.jsp").forward(request, response);
                }
                  else request.getRequestDispatcher("NotFound.jsp").forward(request, response);
            }
            else request.getRequestDispatcher("Notizie").forward(request, response);
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