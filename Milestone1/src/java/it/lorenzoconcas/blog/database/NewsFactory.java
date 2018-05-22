/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lorenzoconcas.blog.database;

import it.lorenzoconcas.blog.objects.*;
import it.lorenzoconcas.blog.servlet.test;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author lorec
 */
public class NewsFactory {

    private static NewsFactory istance;
    private ArrayList<News> newsList = new ArrayList<>();

    NewsFactory() {

    }

    public static NewsFactory getIstance() {
        if (istance == null) {
            istance = new NewsFactory();
        }
        return istance;
    }

    public ArrayList<News> getNewsList() {
         if (newsList.isEmpty()) {
            getNewsFromServer();
        }
        return newsList;
    }

    private void getNewsFromServer(){
          //otteniamo gli utenti dal server
        try {
            Connection conn = DatabaseManager.getIstance().getConnection();
            if (conn == null) {
                System.out.println("Problema di connessione");
            }
            else {

                Statement stmt = conn.createStatement();
                String sql = "select * from notizia";
                ResultSet set = stmt.executeQuery(sql);

                while (set.next()) {
                    News tempNews = new News();
                    tempNews.setId(set.getInt("id"));
                    tempNews.setTitle(set.getString("titolo"));
                    tempNews.setContent(set.getString("content"));
                    tempNews.setDate(set.getString("dataC"));
                    tempNews.setCategory(set.getString("category"));
                    tempNews.setImageDescription(set.getString("imgDesc"));
                    tempNews.setAuthor(UsersFactory.getIstance().getAuthorByID(set.getInt("autore")));
                    tempNews.setImageUrl(set.getString("urlImg"));
                   
                    newsList.add(tempNews);
                }
                stmt.close();
                conn.close();

            }
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
    
    public News getNewsById(int id) {
        if (newsList.isEmpty()) {
            getNewsFromServer();
        }
        for (News n : newsList) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;
    }

    public ArrayList<News> getNewsByAuthor(User author, int order) {
         if (newsList.isEmpty()) {
            getNewsFromServer();
        }
        ArrayList<News> listToReturn = new ArrayList<>();

        for (News n : newsList) {
            if (author.equals(n.getAuthor())) {
                listToReturn.add(n);
            }
        }
        
          if (listToReturn.size() > 0) {
            //0 : dalla più vecchia alla più nuova
            //1 : viceversa
            switch (order) {
                case 0:
                    return newsList;
                case 1: {
                    ArrayList<News> temp = new ArrayList<>();
                    for (int i = listToReturn.size() - 1; i > -1; i--) {
                        temp.add(listToReturn.get(i));
                    }
                    return temp;
                }
            }
        }
        return listToReturn;
    }

    public ArrayList<News> getNewsByCat(String cat, int order) {
         if (newsList.isEmpty()) {
            getNewsFromServer();
        }
        ArrayList<News> listToReturn = new ArrayList<>();

        for (News n : newsList) {
            if (n.getCategory().equals(cat)) {
                listToReturn.add(n);
            }
        }
        if (listToReturn.size() > 0) {
            //0 : dalla più vecchia alla più nuova
            //1 : viceversa
            switch (order) {
                case 0:
                    return newsList;
                case 1: {
                    ArrayList<News> temp = new ArrayList<>();
                    for (int i = listToReturn.size() - 1; i > -1; i--) {
                        temp.add(listToReturn.get(i));
                    }
                    return temp;
                }
            }
        }
        return listToReturn;
    }

    public ArrayList<News> getNewsByDate(int order) {
         if (newsList.isEmpty()) {
            getNewsFromServer();
        }
        //0 : dalla più vecchia alla più nuova
        //1 : viceversa
        switch (order) {
            case 0:
                return newsList;
            case 1: {
                ArrayList<News> listToReturn = new ArrayList<>();
                for (int i = newsList.size() - 1; i > -1; i--) {
                    listToReturn.add(newsList.get(i));
                }
                return listToReturn;
            }
        }
        return newsList;
    }
}

