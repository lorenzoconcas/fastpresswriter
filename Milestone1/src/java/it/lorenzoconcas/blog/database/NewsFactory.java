/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.lorenzoconcas.blog.database;
import it.lorenzoconcas.blog.objects.*;
import java.util.ArrayList;

/**
 * @author lorec
 */
public class NewsFactory {
    private static NewsFactory istance;
    private ArrayList<News> newsList = new ArrayList<>();
    
    NewsFactory(){
        UsersFactory uF = UsersFactory.getIstance();

        News n1 = new News();

        n1.setId(0);
        n1.setCategory(Categories.getIstance().getCategoryByID(5));
        n1.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        n1.setImageUrl("res/news_pictures/news.image.1.jpg");
        n1.setTitle("Articolo 1");
        n1.setAuthor(uF.getUserById(0));
        n1.setDate("12/04/2008");
        n1.setImageDescription("Lorem Ipsumdolor sit amet");
        
        News n2 = new News();
        n2.setId(1);
        n2.setCategory(Categories.getIstance().getCategoryByID(2));
        n2.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque hendrerit tincidunt dolor");
        n2.setImageUrl("M2/news.image.2.jpg");
        n2.setTitle("Articolo 2");
        n2.setAuthor(uF.getUserById(1));
        n2.setDate("25/05/2012");
        n2.setImageDescription("Lorem Ipsumdolor sit amet");
        
        News n3 = new News();
        n3.setId(2);
        n3.setCategory(Categories.getIstance().getCategoryByID(1));
        n3.setContent("Lorem Ipsumdolor sit amet");
        n3.setImageUrl("M2/news.image.3.jpg");
        n3.setTitle("Articolo 3");
        n3.setAuthor(uF.getUserById(2));
        n3.setDate("6/11/2017");
        n3.setImageDescription("Lorem Ipsumdolor sit amet");
        newsList.add(n1);
        newsList.add(n2);
        newsList.add(n3);
    }
    
        public static NewsFactory getIstance() {
        if (istance == null) {
            istance = new NewsFactory();
        }
        return istance;
    }

    public ArrayList<News> getNewsList() {
        return newsList;
    }

    public News getNewsById(int id) {
        for (News n : newsList) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;
    }

    public ArrayList<News> getNewsByAuthor(User author) {
        ArrayList<News> listToReturn = new ArrayList<>();

        for (News n : newsList) {
            if (author.equals(n.getAuthor())) {
                listToReturn.add(n);
            }
        }
        return listToReturn;
    }

    public ArrayList<News> getNewsByCat(Categories cat) {
        ArrayList<News> listToReturn = new ArrayList<>();

        for (News n : newsList) {
            if (n.getCategory().equals(cat)) {
                listToReturn.add(n);
            }
        }

        return listToReturn;
    }
}
