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
import java.util.ArrayList;
import java.util.Date;
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
    private List<ICase> allCases;
    
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
    
    public void setUserMap(Map<String, IUser> users){
    
        for (Map.Entry<String, IUser> entry : users.entrySet()){
            userMap.put(entry.getKey(), new User(entry.getValue().getIDNumber(),
                                                 entry.getValue().getName(),
                                                 entry.getValue().getUsername(),
                                                 entry.getValue().getPassword(),
                                                 entry.getValue().getLog(),
                                                 entry.getValue().getMedicine(),
                                                 entry.getValue().getAppointment(),
                                                 entry.getValue().getCaseaccess()));
        }
  
    }
    
    public IData getData(){
        return  data;
    }
    
    public List<ICase> searchCases(Date date){
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if(aCase.getCreationDate().equals(date)){
                cases.add(aCase);
            }
        }
        return cases;
    }
    
    public List<ICase> searchCases(String CPR){
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if(aCase.getCPR().equals(CPR)){
                cases.add(aCase);
            }
        }
        return cases;
    }
    
    public List<ICase> searchCases(int id){
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if(aCase.getCaseNumber() == id){
                cases.add(aCase);
            }
        }
        return cases;
    }
    
    public List<ICase> searchCases(Date date, String CPR){
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if(aCase.getCreationDate().equals(date) && aCase.getCPR().equals(CPR)){
                cases.add(aCase);
            }
        }
        return cases;
    }
    
    public List<ICase> searchCases(Date date, int id){
        List<ICase> cases = new ArrayList<>();
                for (ICase aCase : allCases) {
            if(aCase.getCreationDate().equals(date) && aCase.getCaseNumber() == id){
                cases.add(aCase);
            }
        }
        return cases;
    }
    
    public List<ICase> searchCases(String CPR, int id){
        List<ICase> cases = new ArrayList<>();
                for (ICase aCase : allCases) {
            if(aCase.getCPR().equals(CPR) && aCase.getCaseNumber()== id){
                cases.add(aCase);
            }
        }

        return cases;
    }
    
    public List<ICase> searchCases(Date date, String CPR, int id){
        List<ICase> cases = new ArrayList<>();
                for (ICase aCase : allCases) {
            if(aCase.getCreationDate().equals(date) && aCase.getCPR().equals(CPR) && aCase.getCaseNumber() == id){
                cases.add(aCase);
            }
        }
        return cases;
    }
    
}
