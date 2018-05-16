/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IUser;
import java.util.HashMap;


public class Business {
    private boolean loggedIn = false;
    private HashMap<String, String> userMap = new HashMap<>();
    private IUser currentUser;
    public Business() {
    }
    
    
     
    public boolean login(String username, String password) {
        
        User admin = new User("admin", "admin", 10, 10);
        userMap.put("admin", "admin");
        if (userMap.containsKey(username)) {
            if (password.equals(userMap.get(username))) {
                return true;
            } else {
            }
        }
        return false;
    }

    /**
     * @return the currentUser
     */
    public IUser getCurrentUser() {
        return currentUser;
    }
}
