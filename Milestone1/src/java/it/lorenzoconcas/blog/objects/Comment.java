/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.lorenzoconcas.blog.objects;

/**
 * @author lorec
 */
public class Comment {

    private User commentAuthor;
    private String comment;
    private int newsID;
    private int commentID;
    public Comment(){
        this.commentAuthor = new User();
        this.comment = "";
        this.newsID = -1;
        this.commentID = -1;
    }
    
    /**
     * @return the commentAutor
     */
    public User getCommentAuthor() {
        return commentAuthor;
    }

    /**
     * @param commentAuthor the commentAutor to set
     */
    public void setCommentAuthor(User commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the newsID
     */
    public int getNewsID() {
        return newsID;
    }

    /**
     * @param newsID the newsID to set
     */
    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    /**
     * @return the commentID
     */
    public int getCommentID() {
        return commentID;
    }

    /**
     * @param commentID the commentID to set
     */
    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }
}
