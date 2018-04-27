/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.unica.m2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author lorec
 */
public class NewsDetails extends HttpServlet {

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
           String id;
           id = request.getParameter("id");
            NotizieFactory nF = NotizieFactory.getIstance();
         
           if(Integer.parseInt(id) < nF.getNewsList().size()){
               Random randomL = new Random();
                Notizia n = nF.getNewsById(Integer.parseInt(id));
                CommentsFactory cF = CommentsFactory.getIstance();
                if(cF.getCommentByNewsID(Integer.parseInt(id)).size() > 0)
                    request.setAttribute("isCommented", true);
                else
                    request.setAttribute("isCommented", false);
                out.println(cF.getCommentByNewsID(Integer.parseInt(id)).size() > 0);
                request.setAttribute("randomLike", randomL);
                request.setAttribute("comments", cF.getCommentByNewsID(Integer.parseInt(id)));
                request.setAttribute("author", n.getAutore());
                request.setAttribute("newsTitle", n.getTitolo());
                request.setAttribute("imageUrl", n.getImg());
                request.setAttribute("newsContent", n.getContent());
                request.setAttribute("newsCat", n.getCategoria());
                request.getRequestDispatcher("newsDetails.jsp").forward(request, response);
           }
           else{
               request.getRequestDispatcher("notImplementedPage.jsp").forward(request, response);
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
