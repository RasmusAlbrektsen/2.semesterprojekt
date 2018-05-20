/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.ICalendar;
import Acq.ICase;
import Acq.IData;
import Acq.IUser;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Business {
    private static Business business = null;
    private IData data;
    private boolean loggedIn = false;
    private Map<String, IUser> userMap = new HashMap<>();
    private IUser currentUser;
    private ICalendar calendar;
    private List<ICase> cases = new ArrayList<>();
    
    private Business() {
        calendar = new Calendar();
        business = this;
    }
    
    public void setData(IData data){
        this.data = data;
    }
    
    public static Business getInstance(){
        if (business == null){
            business = new Business();
        }
        return business;
    }
     
    public boolean login(String username, String password) {
        
        if (userMap.containsKey(username)) {
            if (password.equals(userMap.get(username).getPassword())) {
                currentUser = userMap.get(username);
                return true;
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
    
    public ICalendar getCalendar(){
        return calendar;
    }
    
    public void setUserMap(){
        ResultSet rs = Business.getInstance().getData().getAllUsers();
        try{
            while (rs.next()) {
                    userMap.put(rs.getString("username"), new User(rs.getInt("id"),
                                                                   rs.getString("name"),
                                                                   rs.getString("username"), 
                                                                   rs.getString("password"),
                                                                   rs.getBoolean("log"), 
                                                                   rs.getBoolean("medicine"), 
                                                                   rs.getBoolean("appointment"), 
                                                                   rs.getBoolean("caseAccess")));

                                        
                }
        } catch(Exception e){
            e.printStackTrace();
        }
  
    }

    public IData getData() {
        return data;
    }
    
    public void setCaseList() {
        ResultSet rs = Business.getInstance().getData().getAllCases();
        try{
            while (rs.next()) {
                    cases.add(new Case(rs.getInt("id"),
                                         rs.getString("case_directory"),
                                         rs.getString("creation_date"), 
                                         rs.getString("cpr"),
                                         rs.getBoolean("is_active")));

                                        
                }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<ICase> getCases() {
        return cases;
    }
    
    
}
