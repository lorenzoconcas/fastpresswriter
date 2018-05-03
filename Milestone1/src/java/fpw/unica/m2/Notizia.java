/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.unica.m2;

import java.util.Random;

/**
 * 
 * @author lorec
 */
public class Notizia {

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    
    private int id;
    private String titolo;
    private String content;
    private String img;
    private String categoria;
    private Utenti autore;
    private String date;


    public Notizia(){
        this.id = 0;
        this.titolo = "Titoloplaceholder";
        this.content= "Contenutobello";
        this.img= "";
        this.categoria = "";
        this.autore = new Utenti();
        this.date = "";
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
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @param titolo the titolo to set
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
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
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the autore
     */
    public Utenti getAutore() {
        return autore;
    }

    /**
     * @param autore the autore to set
     */
    public void setAutore(Utenti autore) {
        this.autore = autore;
    }
    public String getContentPreview(){
        //restituisce l'anteprima del contenuto 
        if(this.content.length() > 100)
            return this.content.substring(0, 100);
            else return this.content;
    }
    
    public String getDate(){
       return this.date;
    }
  
}
