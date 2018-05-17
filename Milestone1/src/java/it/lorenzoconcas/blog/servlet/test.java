/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lorenzoconcas.blog.servlet;

import it.lorenzoconcas.blog.database.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lorec
 */
public class test extends HttpServlet {
   

    
    
   
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print("Tento la connessione... <br/>");
            try {
                out.print(DatabaseManager.getIstance().insertUser("Tony", "Stark", "tony@starkindustries.com", "jarvis", "n", 1)+"<br/>");
                Connection conn = DatabaseManager.getIstance().getConnection();
                
                Statement stmt = conn.createStatement();
                String sql = "select * from utente";

                ResultSet set = stmt.executeQuery(sql);
               
                if(request.getParameter("email") != null &&  request.getParameter("password") != null){
                    out.print("tento il login");
                    out.print("<br/>");
                     while(set.next()){
                        out.print(set.getString("email"));
                        out.print("<br/>");
                    }
                    set.first();
                       while(set.next()){
                        out.print(set.getString("nome"));
                        out.print("<br/>");
                    }
                }
                
                else{
                    out.print("mmm");
                }
                
              
               stmt.close();
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(test.class.getName()).
                        log(Level.SEVERE, null, ex);
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
