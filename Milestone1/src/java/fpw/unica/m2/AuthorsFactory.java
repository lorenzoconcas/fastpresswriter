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
public class AuthorsFactory {
    private static AuthorsFactory istance;
    private ArrayList<Utenti> listaAutori = new ArrayList<>();
    
    AuthorsFactory(){
        
        NotizieFactory nF = NotizieFactory.getIstance();
        ArrayList<Notizia> n = nF.getNewsList();
        for(Notizia a : n){
            listaAutori.add(a.getAutore());
        }
        
             
    }
    public static AuthorsFactory getIstance(){
        if(istance == null)
            istance = new AuthorsFactory();
        return istance;
    }
    public ArrayList<Utenti> getAutori(){
        return this.listaAutori;
    }
}
