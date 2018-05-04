/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lorenzoconcas.blog.servlet;

import it.lorenzoconcas.blog.database.*;
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

        HttpSession session = request.getSession();
        //richiesta di logout
        if (request.getParameter("logout") != null) {
            session.invalidate();
            request.getRequestDispatcher("notizie.html").forward(request, response);

        }
        //Controllo se nella sessione è presente l'attributo "loggedIn" e che abbia valore true
        //in tal caso l'utente è loggato e deve essere rimanandato all'elenco notizie
        if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) {
            request.getRequestDispatcher("notizie.html").forward(request, response);
        }
        /*
            fallita la verifica di uno dei due casi stabiliamo che l'utente non è collegato,
            pertanto procediamo col login
         */
        else {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            UsersFactory uF = UsersFactory.getIstance();
            //controllo che i dati non siano nulli e validi
            if (email != null && password != null && uF.login(email, password)) {
                int userID = uF.getUserByEmail(email).getId();
                /*imposto vari attributi per questa sessione fra cui l'id dell'utente, 
                    il fatto che sia loggato e l'oggetto utente */
                session.setAttribute("userID", userID);
                session.setAttribute("loggedIn", true);
                session.setAttribute("user", uF.getUserById(userID));
                if (Authors.getIstance().isAuthor(uF.getUserById(userID))) {
                    session.setAttribute("isAuthor", true);
                }
                //rimandiamo infine l'utente alla pagina principale
                request.getRequestDispatcher("notizie.html").forward(request, response);

            }
            //se i valori non sono stati inseriti o non validi, allora rimando alla pagina di login
            //questo caso viene raggiunto quando viene effettuata una richiesta di login che non provenga dal file login.jsp

            else {
                if (email != null || password != null) { //significa che i dati non sono null e sono sbagliati
                    request.setAttribute("invalidData", true);
                }
                request.getRequestDispatcher("Login.jsp").forward(request, response);
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
