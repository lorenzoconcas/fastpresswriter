/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.unica.m2;

import java.util.ArrayList;

/**
 *
 * @author lorec
 */
public class CategoriesFactory {

    private static CategoriesFactory istance;
    private ArrayList<String> categories = new ArrayList<>();

    CategoriesFactory() {
        categories.add("Politica");
        categories.add("Cronaca");
        categories.add("Esteri");
        categories.add("Economia");
        categories.add("Sport");
        categories.add("Cultura");
    }
    public static CategoriesFactory getIstance(){
        if(istance == null)
            istance = new CategoriesFactory();
        return istance;
    }
    public ArrayList<String> getCategories(){
        return categories;
    }
    public String getCategoryByID(int id){
        if(id > categories.size())
            return "Senza Categoria";
        else
            return categories.get(id);        
    }
}
