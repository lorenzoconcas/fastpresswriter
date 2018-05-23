/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lorenzoconcas.blog.database;

import it.lorenzoconcas.blog.objects.User;
import it.lorenzoconcas.blog.servlet.test;
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
//        User u = new User();
//        u.setEmail("lore@glassfish.com");
//        u.setPassword("test");
//        u.setId(0);
//        u.setName("Lore");
//        u.setSurname("concas");
//        u.setIsAuthor(true);
//        u.setImgUrl("res/user_pictures/test_profile_pic.png");
//        userList.add(u);
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
            Logger.getLogger(test.class.getName()).
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

        // getUsersFromServer();
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public User getAuthorByID(int id) {

        // getUsersFromServer();
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
        //getUsersFromServer();

        buildAuthorsList();
        return authorsList;
    }
}
