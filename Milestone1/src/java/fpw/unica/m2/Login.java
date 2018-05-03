/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.unica.m2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 
 *
 * @author lorec
 */
public class Login extends HttpServlet {

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
            //richiesta di logout
            if (request.getParameter("logout") != null){
                session.invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
                
            }
            //Nel caso l'utente sia loggato 
            if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)){
                request.getRequestDispatcher("profilo.html").forward(request, response);  
            }
            else{
                //nel caso non sia loggato
                String email = request.getParameter("email");
                String password = request.getParameter("password");             
                UtentiFactory uF = UtentiFactory.getIstance();        
                //se i dati sono corretti
                if(email != null && password != null && uF.login(email, password)){
                    int userID = uF.getUserByEmail(email).getId();
                    session.setAttribute("userID", userID);
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("user", uF.getUserById(userID));
                    session.setAttribute("invalidData",false);
                    request.getRequestDispatcher("profilo.html").forward(request, response);
                   
                }
                //se i valori non sono stati inseriti o non validi
                else if(email != null && password != null){
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response); 
                }
                //se i valori sono vuoti
                else if("".equals(email) || "".equals(password)){
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response); 
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
