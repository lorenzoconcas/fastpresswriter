/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.lorenzoconcas.blog.database;

import it.lorenzoconcas.blog.objects.News;
import it.lorenzoconcas.blog.objects.User;
import java.util.ArrayList;

/**
 * @author lorec
 */
public class Authors {
 private static Authors istance;
    private ArrayList<User> authorsList = new ArrayList<>();
    
    Authors(){        
        NewsFactory nF = NewsFactory.getIstance();
        ArrayList<News> n = nF.getNewsList();
        for(News a : n){
            authorsList.add(a.getAuthor());
        }      
    }
    public static Authors getIstance(){
        if(istance == null)
            istance = new Authors();
        return istance;
    }
    public ArrayList<User> getAutori(){
        return this.authorsList;
    }
    
    public User getAuthorByID(int id){
        for(User u : authorsList){
            if(u.getId() == id)
                return u;
        }
        return null;
    }
    public Boolean isAuthor(User auth){
        for(User u : authorsList){
            if(u.equals(auth))
                return true;
        }
        return false;
    }
}
