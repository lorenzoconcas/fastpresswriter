/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.lorenzoconcas.blog.objects;

/**
 * @author lorec
 */
public class User {

    /**
     * @return the isAuthor
     */
    public Boolean getIsAuthor() {
        return isAuthor;
    }

    /**
     * @param isAuthor the isAuthor to set
     */
    public void setIsAuthor(Boolean isAuthor) {
        this.isAuthor = isAuthor;
    }

    private String name, surname;
    private int id;
    private String password;
    private String email;
    private String imgUrl;
    private Boolean isAuthor;
    
    public User(){
        this.name = "";
        this.surname = "";
        this.id = -1;
        this.password = "";
        this.email = "";
        this.imgUrl = "";
        this.isAuthor = false;
    }
    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

  
    /**
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
