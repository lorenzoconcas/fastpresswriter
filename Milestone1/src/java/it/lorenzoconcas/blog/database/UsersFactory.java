/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.lorenzoconcas.blog.database;
import it.lorenzoconcas.blog.objects.User;
import java.util.ArrayList;

/**
 * @author lorec
 */
public class UsersFactory {
    private static UsersFactory istance;
    private ArrayList<User> userList = new ArrayList<>();
    
    public UsersFactory(){
        User u1 = new User();
        u1.setId(0);
        u1.setName("Lord");
        u1.setSurname("Fener");
        u1.setEmail("lordfener@impero.com");
        u1.setPassword("theforce");
        u1.setImgUrl("res/user_pictures/header_user_icon.png");
        u1.setUsername("vader");
        
        User u2 = new User();
        u2.setId(1);
        u2.setName("Luke");
        u2.setSurname("Skywalker");
        u2.setEmail("lukeskywalker@resistenza.com");
        u2.setPassword("resistence");
        u2.setImgUrl("res/user_pictures/header_user_icon.png");
        u2.setUsername("luke");
       
        User u3 = new User();
        u3.setId(2);
        u3.setName("Lore");
        u3.setSurname("Concas");
        u3.setEmail("lore@glassfish.com");
        u3.setPassword("test");
        u3.setImgUrl("res/user_pictures/test_profile_pic.png");
        u3.setUsername("lorec");
        
        User u4 = new User();
        u4.setId(3);
        u4.setName("Han");
        u4.setSurname("Solo");
        u4.setEmail("hansolo@resistenza.com");
        u4.setPassword("millenniumfalcon");
        u4.setImgUrl("res/user_pictures/header_user_icon.png");
        u4.setUsername("hansolo");
        
        userList.add(u2);
        userList.add(u1);
        userList.add(u3);
        userList.add(u4);
    }
    
    public static UsersFactory getIstance() {
        if (istance == null) {
            istance = new UsersFactory();
        }
        return istance;

    }
    public ArrayList<User> getUsers() {
        return userList;

    }
    public User getUserById(int id) {
        for (User u : userList) {
            if (u.getId() == id) {
                return u;
            }
        }

        return null;
    }
    
    public boolean login(String email, String password)
    {
        for(User u : userList)
            if (u.getEmail().equals(email) && u.getPassword().equals(password))
                return true;
        
        return false;
    }
    
    public User getUserByEmail(String email) {
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }
}


