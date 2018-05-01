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
public class CommentsFactory {

    private static CommentsFactory istance;
    private ArrayList<Commento> commenti = new ArrayList<>();

    CommentsFactory() {
        UtentiFactory uF = UtentiFactory.getIstance();
        Commento c1, c2, c3, c4, c5;

        //commento dell'utente con id 0
        c1 = new Commento();
        c1.setAutoreCommento(uF.getUserById(0));
        c1.setCommento("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        c1.setIdCommento(0);
        c1.setIdNotizia(0); // si riferisce alla notizia 0

        //commento dell'utente con id 1
        c2 = new Commento();
        c2.setAutoreCommento(uF.getUserById(1));
        c2.setCommento("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        c2.setIdCommento(1);
        c2.setIdNotizia(0); // si riferisce alla notizia 0

        //commento dell'utente con id 2
        c3 = new Commento();
        c3.setAutoreCommento(uF.getUserById(2));
        c3.setCommento("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        c3.setIdCommento(2);
        c3.setIdNotizia(0);

        //commento dell'utente con id 0
        c4 = new Commento();
        c4.setAutoreCommento(uF.getUserById(0));
        c4.setCommento("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        c4.setIdCommento(3);
        c4.setIdNotizia(1);

        //commento dell'utente con id 1
        c5 = new Commento();
        c5.setAutoreCommento(uF.getUserById(1));
        c5.setCommento("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        c5.setIdCommento(1);
        c5.setIdNotizia(1);

        commenti.add(c1);
        commenti.add(c2);
        commenti.add(c3);
        commenti.add(c4);
        commenti.add(c5);
    }

    public static CommentsFactory getIstance() {
        if (istance == null) {
            istance = new CommentsFactory();
        }
        return istance;
    }

    public ArrayList<Commento> getCommentByNewsID(int id) {
        ArrayList<Commento> listToReturn = new ArrayList<>();

        for (Commento c : commenti) {
            if (c.getIdNotizia() == id) {
                listToReturn.add(c);
            }

        }

        return listToReturn;
    }
}
