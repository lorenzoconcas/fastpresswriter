/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lorenzoconcas.blog.objects;


/**
 *
 * @author lorec
 */
public class News {

    //settiamo le proprietà dell'oggetto News, che corrisponde al nostro ideale di notizia
    private int id; //id univoco dell'articolo
    private String title, content;
    private String date;
    private User author;
    private String imageUrl;
    private String imageDescription;
    private String category;
    
    public News(){
        this.title = "";
        this.content = "";
        this.id = -1;
        this.date = "06/05/2018";
        this.author = new User();
        this.imageUrl = "/res/site_resources/picture_not_set.png";
        this.imageDescription = "";
        
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the autore
     */
    public User getAuthor() {
        return author;
    }

    /**
     * @param autore the autore to set
     */
    public void setAuthor(User autore) {
        this.author = autore;
    }

    /**
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl the imageUrl to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * @return the imageDescription
     */
    public String getImageDescription() {
        return imageDescription;
    }

    /**
     * @param imageDescription the imageDescription to set
     */
    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }
}
