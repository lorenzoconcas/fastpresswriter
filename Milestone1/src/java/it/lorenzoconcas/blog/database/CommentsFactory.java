/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.lorenzoconcas.blog.database;

import it.lorenzoconcas.blog.objects.Comment;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author lorec
 */
public class CommentsFactory {

    private static CommentsFactory istance;
    private ArrayList<Comment> commentList = new ArrayList<>();

    public CommentsFactory() {

    }

    public static CommentsFactory getIstance() {
        if (istance == null) {
            istance = new CommentsFactory();
        }
        return istance;
    }

    private void getCommentsFromServer() {
         commentList.clear();
        //otteniamo gli utenti dal server
        try {
            Connection conn = DatabaseManager.getIstance().getConnection();
            if (conn == null) {
                System.out.println("Problema di connessione");
            }
            else {

                Statement stmt = conn.createStatement();
                String sql = "select * from commenti";
                ResultSet set = stmt.executeQuery(sql);

                while (set.next()) {
                    Comment tempComment = new Comment();
                    tempComment.setCommentID(set.getInt("commentID"));
                    tempComment.setComment(set.getString("comment"));
                    tempComment.setCommentAuthor(UsersFactory.getIstance().getAuthorByID(set.getInt("commentAuthor")));
                    tempComment.setNewsID(set.getInt("newsID"));                  
                    commentList.add(tempComment);
                }
                stmt.close();
                conn.close();

            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentsFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

    
    public ArrayList<Comment> getCommentByNewsID(int id) {
       
            getCommentsFromServer();
        
        ArrayList<Comment> listToReturn = new ArrayList<>();

        for (Comment c : commentList) {
            if (c.getNewsID()== id) {
                listToReturn.add(c);
            }
        }
        return listToReturn;
    }
    
   
    public boolean insertComment(int authorID, int newsID, String comment){
        boolean insert_OK = false;
        try
        {
            Connection conn = DatabaseManager.getIstance().getConnection();
            String sql = "insert into commenti values (default, ?, ?, ?) ";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,authorID);
            stmt.setInt(2,newsID);
            stmt.setString(3,comment);
            
            int rows = stmt.executeUpdate();
            if(rows == 1){              
                insert_OK = true;
            }
            // chiudo lo statement
            stmt.close();
            // chiusura della connessione
            conn.close();    
            
        }catch(SQLException e)
        {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
             Logger.getLogger(CommentsFactory.class.getName()).
                    log(Level.SEVERE, null, e);
        }
        return insert_OK;     
    }
}
