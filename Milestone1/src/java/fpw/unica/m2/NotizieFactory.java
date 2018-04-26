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
public class NotizieFactory {
    private static NotizieFactory istance;
    private ArrayList<Notizia> listaNotizie = new ArrayList<>();
    
    
    private NotizieFactory(){
        UtentiFactory uF = UtentiFactory.getIstance();
        
        Notizia n1 = new Notizia();
        
        n1.setId(0);
        n1.setCategoria("Cultura");
        n1.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque hendrerit tincidunt dolor, a malesuada ipsum cursus eget.");
        n1.setImg("M2/news.image.1.jpg");
        n1.setTitolo("Articolo 1");
        n1.setAutore(uF.getUserById(0));

        Notizia n2 = new Notizia();
        
        n2.setId(1);
        n2.setCategoria("Arte");
        n2.setContent("Lorem Ipsumdolor sit amet");
        n2.setImg("M2/news.image.2.jpg");
        n2.setTitolo("Articolo 2");
        n2.setAutore(uF.getUserById(1));
        
        Notizia n3 = new Notizia();
        
        n3.setId(2);
        n3.setCategoria("Arte");
        n3.setContent("Lorem Ipsumdolor sit amet");
        n3.setImg("M2/news.image.3.jpg");
        n3.setTitolo("Articolo 3");
        n3.setAutore(uF.getUserById(2));
        
        listaNotizie.add(n1);
        listaNotizie.add(n2);
        listaNotizie.add(n3);
    }
    
    public static NotizieFactory getIstance(){
        if(istance == null)
            istance = new NotizieFactory();
        return istance;
    }
    public ArrayList<Notizia> getNewsList()
    {
        return listaNotizie;
    }
    public Notizia getNewsById(int id)
    {
        for (Notizia news : listaNotizie)
            if (news.getId() == id)
                return news;
        
        return null;
    }
    
    public ArrayList<Notizia> getNewsByAuthor(Utenti author)
    {
        ArrayList<Notizia> listToReturn = new ArrayList<>();
        
        for (Notizia news : listaNotizie)
            if (author.equals(news.getAutore()))
                listToReturn.add(news);
            
        return listToReturn;
    }
}
