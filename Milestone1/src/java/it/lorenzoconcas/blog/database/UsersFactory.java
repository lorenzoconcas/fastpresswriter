/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lorenzoconcas.blog.database;

import it.lorenzoconcas.blog.objects.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author lorec
 */
public class UsersFactory {

    private static UsersFactory istance;
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<User> authorsList = new ArrayList<>();

    public UsersFactory() {

    }

    public static UsersFactory getIstance() {
        if (istance == null) {
            istance = new UsersFactory();
        }
        return istance;

    }

    private void getUsersFromServer() {
       userList.clear();
        //otteniamo gli utenti dal server
        try {
            Connection conn = DatabaseManager.getIstance().getConnection();
            if (conn == null) {
                System.out.println("Problema di connessione");
            }
            else {

                Statement stmt = conn.createStatement();
                String sql = "select * from utente";
                ResultSet set = stmt.executeQuery(sql);

                while (set.next()) {
                    User tempUser = new User();
                    tempUser.setId(set.getInt("id"));
                    tempUser.setName(set.getString("nome"));
                    tempUser.setSurname(set.getString("cognome"));
                    tempUser.setEmail(set.getString("email"));
                    tempUser.setPassword(set.getString("password"));
                    tempUser.setImgUrl(set.getString("urlImg"));
                    tempUser.setIsAuthor(set.getBoolean("isAuthor"));
                    userList.add(tempUser);
                }
                stmt.close();
                conn.close();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<User> getUsers() {

        getUsersFromServer();
        return userList;

    }

    public User getUserById(int id) {

        getUsersFromServer();
        for (User u : userList) {
            if (u.getId() == id) {
                return u;
            }
        }

        return null;
    }

    public boolean login(String email, String password) {

        getUsersFromServer();
        for (User u : userList) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public User getUserByEmail(String email) {

         getUsersFromServer();
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public User getAuthorByID(int id) {

         getUsersFromServer();
        authorsList.clear();
        buildAuthorsList();

        for (User u : authorsList) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    private void buildAuthorsList() {
        for (User a : userList) {
            if (a.getIsAuthor()) {
                authorsList.add(a);
            }
        }
    }

    public ArrayList<User> getAuthors() {

        authorsList.clear();
        getUsersFromServer();

        buildAuthorsList();
        return authorsList;
    }

    public boolean deleteUser(int userID) {
        Connection conn = null;

        try {
            conn = DatabaseManager.getIstance().getConnection();

            conn.setAutoCommit(false);
            String post = "DELETE FROM notizia WHERE autore = ?";
            String comment = "DELETE FROM commenti WHERE commentAuthor = ?";
            String user = "DELETE FROM utente WHERE id = ?";
            PreparedStatement removePost, removeUser, removeComment;

            removePost = conn.prepareStatement(post);
            removePost.setInt(1, userID);
            removePost.executeUpdate();

            removeComment = conn.prepareStatement(comment);
            removeComment.setInt(1, userID);
            removeComment.executeUpdate();

            removeUser = conn.prepareStatement(user);
            removeUser.setInt(1, userID);
            removeUser.executeUpdate();
            conn.commit();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(UsersFactory.class.getName()).
                    log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(UsersFactory.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
            return false;
        }

    }

    public boolean insertUser(String nome, String cognome, String email,
            String password, boolean isAuthor) {
        boolean insert_OK = false;
        try {
            Connection conn = DatabaseManager.getIstance().getConnection();
            String sql = "insert into utente values (default, ?, ?, ?, ?, ?, ?) ";
          
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, "res/user_pictures/header_user_icon.png");
            stmt.setBoolean(6, isAuthor);

            int rows = stmt.executeUpdate();
            if (rows == 1) {

                insert_OK = true;
            }
            // chiudo lo statement
            stmt.close();
            // chiusura della connessione
            conn.close();

        } catch (SQLException e) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(UsersFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return insert_OK;

    }
}
