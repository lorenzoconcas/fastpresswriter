/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.lorenzoconcas.blog.database;

import it.lorenzoconcas.blog.objects.Comment;
import java.util.ArrayList;

/**
 * @author lorec
 */
public class CommentsFactory {

    private static CommentsFactory istance;
    private ArrayList<Comment> commentList = new ArrayList<>();

    public CommentsFactory() {
        UsersFactory uF = UsersFactory.getIstance();
        Comment c1, c2, c3, c4, c5;

        //commento dell'utente con id 0
        c1 = new Comment();
        c1.setCommentAuthor(uF.getUserById(0));
        c1.setComment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        c1.setCommentID(0);
        c1.setNewsID(0); // si riferisce alla notizia 0

        //commento dell'utente con id 1
        c2 = new Comment();
        c2.setCommentAuthor(uF.getUserById(1));
        c2.setComment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        c2.setCommentID(1);
        c2.setNewsID(0); // si riferisce alla notizia 0

        //commento dell'utente con id 2
        c3 = new Comment();
        c3.setCommentAuthor(uF.getUserById(2));
        c3.setComment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        c3.setCommentID(2);
        c3.setNewsID(0);

        //commento dell'utente con id 0
        c4 = new Comment();
        c4.setCommentAuthor(uF.getUserById(0));
        c4.setComment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        c4.setCommentID(3);
        c4.setNewsID(1);

        //commento dell'utente con id 1
        c5 = new Comment();
        c5.setCommentAuthor(uF.getUserById(1));
        c5.setComment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        c5.setCommentID(1);
        c5.setNewsID(1);

        commentList.add(c1);
        commentList.add(c2);
        commentList.add(c3);
        commentList.add(c4);
        commentList.add(c5);
    }

    public static CommentsFactory getIstance() {
        if (istance == null) {
            istance = new CommentsFactory();
        }
        return istance;
    }

    public ArrayList<Comment> getCommentByNewsID(int id) {
        ArrayList<Comment> listToReturn = new ArrayList<>();

        for (Comment c : commentList) {
            if (c.getNewsID()== id) {
                listToReturn.add(c);
            }
        }
        return listToReturn;
    }
}
