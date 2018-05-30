/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lorenzoconcas.blog.database;

import it.lorenzoconcas.blog.objects.*;
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
//        News n1 = new News();
//        UsersFactory uF = UsersFactory.getIstance();
//        n1.setId(0);
//        n1.setCategory(Categories.getIstance().getCategoryByID(5));
//        n1.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
//        n1.setImageUrl("res/news_pictures/news.image.1.jpg");
//        n1.setTitle("Articolo 1");
//        n1.setAuthor(uF.getUserById(0));
//        n1.setDate("12/04/2008");
//        n1.setImageDescription("Lorem Ipsumdolor sit amet");
//        
//        News n2 = new News();
//        n2.setId(1);
//        n2.setCategory(Categories.getIstance().getCategoryByID(2));
//        n2.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque hendrerit tincidunt dolor");
//        n2.setImageUrl("res/news_pictures/news.image.2.jpg");
//        n2.setTitle("Articolo 2");
//        n2.setAuthor(uF.getUserById(1));
//        n2.setDate("25/05/2012");
//        n2.setImageDescription("Lorem Ipsumdolor sit amet");
//        
//        News n3 = new News();
//        n3.setId(2);
//        n3.setCategory(Categories.getIstance().getCategoryByID(1));
//        n3.setContent("Lorem Ipsumdolor sit amet");
//        n3.setImageUrl("res/news_pictures/news.image.3.jpg");
//        n3.setTitle("Articolo 3");
//        n3.setAuthor(uF.getUserById(2));
//        n3.setDate("6/11/2017");
//        n3.setImageDescription("Lorem Ipsumdolor sit amet");
//        newsList.add(n1);
//        newsList.add(n2);
//        newsList.add(n3);
    }

    public static NewsFactory getIstance() {
        if (istance == null) {
            istance = new NewsFactory();
        }
        return istance;
    }

    public ArrayList<News> getNewsList() {

        getNewsFromServer();
        return newsList;
    }

    private void getNewsFromServer() {
        newsList.clear();
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
                System.out.println(set);
                while (set.next()) {
                    News tempNews = new News();
                    UsersFactory u = UsersFactory.getIstance();
                    tempNews.setId(set.getInt("id"));
                    tempNews.setTitle(set.getString("titolo"));
                    tempNews.setContent(set.getString("content"));
                    tempNews.setDate(set.getString("dataC"));
                    tempNews.setCategory(set.getString("category"));
                    tempNews.setImageDescription(set.getString("imgDesc"));
                    tempNews.setAuthor(u.getAuthorByID(set.getInt("autore")));
                    tempNews.setImageUrl(set.getString("img"));

                    newsList.add(tempNews);
                }
                stmt.close();
                conn.close();

            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsFactory.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

    public News getNewsById(int id) {

        getNewsFromServer();

        for (News n : newsList) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;
    }

    public ArrayList<News> getNewsByAuthor(int authorID, int order) {

        getNewsFromServer();
        ArrayList<News> listToReturn = new ArrayList<>();

        for (News n : newsList) {
            if (authorID == n.getAuthor().getId()) {
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

        getNewsFromServer();
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

    public boolean authorOwnsArticle(int articleID, int authorID) {

        for (News n : newsList) {
            if (n.getId() == articleID) {
                if (n.getAuthor().getId() == authorID) {
                    return true;
                }
            }
        }
        return true;
    }

    public ArrayList<News> getNewsByDate(int order) {

        getNewsFromServer();
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

    public boolean insertNews(String title, String content, String imgUrl, String imgDesc, String articleDate, String category, int authorID) {
        boolean insert_OK = false;
        try {
            Connection conn = DatabaseManager.getIstance().getConnection();
            String sql = "insert into notizia values (default, ?, ?, ?,?, ?, ?, ?) ";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setString(3, imgUrl);
            stmt.setString(4, imgDesc);
            stmt.setString(5, category);
            stmt.setString(6, articleDate);
            stmt.setInt(7, authorID);

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
            Logger.getLogger(NewsFactory.class.getName()).
                    log(Level.SEVERE, null, e);
        }
        return insert_OK;

        
    }

    public boolean deleteNews(int newsID) {
        Connection conn = null;

        try {
            conn = DatabaseManager.getIstance().getConnection();

            conn.setAutoCommit(false);
            String post = "DELETE FROM notizia WHERE id = ?";

            PreparedStatement removePost;

            removePost = conn.prepareStatement(post);
            removePost.setInt(1, newsID);
            removePost.executeUpdate();

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

}
