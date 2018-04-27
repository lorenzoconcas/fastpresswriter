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
public class UtentiFactory {
    private static UtentiFactory istance;
    private ArrayList<Utenti> users = new ArrayList<>();
    UtentiFactory(){
        Utenti u1 = new Utenti();
        u1.setId(0);
        u1.setName("Lord");
        u1.setSurname("Fener");
        u1.setEmail("lordfener@impero.com");
        u1.setPassword("theforce");
        u1.setImgUrl("M2/header_user_icon.png");
        u1.setUsername("vader");
        
        Utenti u2 = new Utenti();
        u2.setId(1);
        u2.setName("Luke");
        u2.setSurname("Skywalker");
        u2.setEmail("lukeskywalker@resistenza.com");
        u2.setPassword("resistence");
        u2.setImgUrl("M2/header_user_icon.png");
        u2.setUsername("luke");
       
        Utenti u3 = new Utenti();
        u3.setId(2);
        u3.setName("Lore");
        u3.setSurname("Concas");
        u3.setEmail("lore@glassfish.com");
        u3.setPassword("test");
        u3.setImgUrl("M2/test_profile_pic.png");
        u3.setUsername("lorec");
        
        users.add(u2);
        users.add(u1);
        users.add(u3);
    }
    
    public static UtentiFactory getIstance(){
        if(istance == null)
            istance =  new UtentiFactory();
         return istance;
     
    }
    
    public ArrayList<Utenti> getUsers(){
        return users;
        
    }
    
    public Utenti getUserById(int id)
    {
        for (Utenti user : users)
            if (user.getId() == id)
                return user;
        
        return null;
    }
    
      public boolean login(String email, String password)
    {
        for(Utenti user : users)
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                return true;
        
        return false;
    }
        public Utenti getUserByEmail(String email)
    {
        for (Utenti user: users)
            if (user.getEmail().equals(email))
                return user;
        
        return null;
    }
   

  
}
        
