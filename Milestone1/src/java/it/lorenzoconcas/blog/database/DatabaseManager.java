/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.lorenzoconcas.blog.database;

import java.sql.*;
import java.util.logging.*;

/**
 * @author lorec
 */
public class DatabaseManager {
     private static DatabaseManager singleton;
     
   public DatabaseManager(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) {
           Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static DatabaseManager getIstance(){
        if(singleton == null)
            singleton = new DatabaseManager();
        return singleton;
    }
    
    public Connection getConnection(){
        Connection conn = null;
        String conn_str = "jdbc:mysql://ec2-52-47-198-123.eu-west-3.compute.amazonaws.com:443/fpw18_concaslorenzo";
    
        try{
            conn = DriverManager.getConnection(conn_str, "fpw18_concaslorenzo", "lorenzoconcas");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
       
        return conn;
       
    }
    public boolean insertUser(String name, String surname, String email, String password, String urlImg, int isAuthor){
        boolean insert = false;
        try{
            Connection conn = this.getConnection();
            String sql = "insert into utente values(deafault, ?, ?, ?, ?,?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, urlImg);
            stmt.setInt(6, isAuthor);
            int rows = stmt.executeUpdate();
            if(rows==1){
                insert = true;
            }
            stmt.close();
            conn.close();
            
        }
        catch(SQLException e){
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return insert;
    }
}
