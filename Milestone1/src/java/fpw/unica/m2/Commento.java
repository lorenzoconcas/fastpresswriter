/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpw.unica.m2;

/**
 *
 * @author lorec
 */
public class Commento {

    

   private Utenti autoreCommento;
   private String commento;
   private int idNotizia;
   private int idCommento;
    
   Commento(){
       this.autoreCommento = new Utenti();
       this.commento = "";
       this.idNotizia = 0;
       this.idCommento = 0;
   }
   
   /**
     * @return the autoreCommento
     */
    public Utenti getAutoreCommento() {
        return autoreCommento;
    }

    /**
     * @param autoreCommento the autoreCommento to set
     */
    public void setAutoreCommento(Utenti autoreCommento) {
        this.autoreCommento = autoreCommento;
    }

    /**
     * @return the commento
     */
    public String getCommento() {
        return commento;
    }

    /**
     * @param commento the commento to set
     */
    public void setCommento(String commento) {
        this.commento = commento;
    }

    /**
     * @return the idNotizia
     */
    public int getIdNotizia() {
        return idNotizia;
    }

    /**
     * @param idNotizia the idNotizia to set
     */
    public void setIdNotizia(int idNotizia) {
        this.idNotizia = idNotizia;
    }

    /**
     * @return the idCommento
     */
    public int getIdCommento() {
        return idCommento;
    }

    /**
     * @param idCommento the idCommento to set
     */
    public void setIdCommento(int idCommento) {
        this.idCommento = idCommento;
    }
}
