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
        UtentiFactory uF = UtentiFactory.getIstance();
        NotizieFactory nF = NotizieFactory.getIstance();
        
         //dobbiamo capire quali di loro sono anche autori
        ArrayList<Utenti> utenti = uF.getUsers();
        ArrayList<Notizia> notizie = nF.getNewsList();
   
        listaAutori.add(utenti.get(0));
             
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
