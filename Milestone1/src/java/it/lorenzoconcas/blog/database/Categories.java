/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.lorenzoconcas.blog.database;

import java.util.ArrayList;

/**
 * @author lorec
 */
public class Categories {
    private static Categories istance;
    private ArrayList<String> categoriesList = new ArrayList<>();
    Categories(){
        categoriesList.add("Tutte");
        categoriesList.add("Politica");
        categoriesList.add("Cronaca");
        categoriesList.add("Esteri");
        categoriesList.add("Economia");
        categoriesList.add("Sport");
        categoriesList.add("Cultura");
    }
     
    public static Categories getIstance(){
        if(istance == null)
            istance = new Categories();
        return istance;
    }
    public ArrayList<String> getCategories(){
        return categoriesList;
    }
    public String getCategoryByID(int id){
        if(id > categoriesList.size())
            return "Senza Categoria";
        else
            return categoriesList.get(id);        
    }
   
}
