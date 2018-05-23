/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IUserLog;
import Acq.ICalendar;
import Acq.ICase;
import Acq.ICaseLog;
import Acq.IData;
import Acq.IUser;
import java.sql.ResultSet;
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
    private List<ICase> allCases = new ArrayList();
    private List<ICaseLog> caseLog = new ArrayList();
    private List<IUserLog> userLog = new ArrayList<>();

    private Business() {
        calendar = new Calendar();
        business = this;
    }

    public void setData(IData data) {
        this.data = data;
    }

    public static Business getInstance() {
        if (business == null) {
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

    public ICalendar getCalendar() {
        return calendar;
    }

    public void setUserMap() {
        ResultSet rs = Business.getInstance().getData().getAllUsers();
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setCaseList() {
        ResultSet rs = Business.getInstance().getData().getAllCases();
        try {
            while (rs.next()) {
                allCases.add(new Case(rs.getInt("caseid"),
                        rs.getString("case_directory"),
                        rs.getString("creation_date"),
                        rs.getString("cpr"),
                        rs.getBoolean("is_active")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ICase> getCases() {
        return allCases;
    }

    public IData getData() {
        return data;
    }

    public Map<String, IUser> getUserMap() {
        return userMap;
    }

    public List<ICaseLog> getCaseLog() {
        return caseLog;
    }

    public List<IUserLog> getUserLog() {
        return userLog;
    }

    public void saveCase(String CPR, String info) {
        new Case(CPR, info).saveCase(currentUser.getIDNumber());
    }
    
    public void updateCase(ICase aCase, String info){
        aCase.updateCase(currentUser.getIDNumber(),info);
    }
    
    public void deleteCase(ICase aCase){
        aCase.deleteCase();
    }
    
    public void saveUser(String name, String username, String password) {
        new User(name, username, password).saveUser(getCurrentUser().getIDNumber());
    }

    public List<ICase> searchCases(Date date) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCreationDate().equals(calendar.formatToString(date))) {
                cases.add(aCase);
            }
        }
        return cases;
    }

    public List<ICase> searchCases(String CPR) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCPR().equals(CPR)) {
                cases.add(aCase);
            }
        }
        return cases;
    }

    public List<ICase> searchCases(int id) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCaseNumber() == id) {
                cases.add(aCase);
            }
        }
        return cases;
    }

    public List<ICase> searchCases(Date date, String CPR) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCreationDate().equals(calendar.formatToString(date)) && aCase.getCPR().equals(CPR)) {
                cases.add(aCase);
            }
        }
        return cases;
    }

    public List<ICase> searchCases(Date date, int id) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCreationDate().equals(calendar.formatToString(date)) && aCase.getCaseNumber() == id) {
                cases.add(aCase);
            }
        }
        return cases;
    }

    public List<ICase> searchCases(String CPR, int id) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCPR().equals(CPR) && aCase.getCaseNumber() == id) {
                cases.add(aCase);
            }
        }

        return cases;
    }

    public List<ICase> searchCases(Date date, String CPR, int id) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCreationDate().equals(calendar.formatToString(date)) && aCase.getCPR().equals(CPR) && aCase.getCaseNumber() == id) {
                cases.add(aCase);
            }
        }
        return cases;
    }
    
    public void setCaseLogs() {
        ResultSet rs = Business.getInstance().getData().getCaseLog();
           try{
            while (rs.next()) {
                caseLog.add(new CaseLog(rs.getInt("userid"),
                        rs.getInt("caseid"),
                        rs.getString("date"),
                        rs.getString("time")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public void setUserLogs() {
        ResultSet rs = Business.getInstance().getData().getCaseLog();
           try{
            while (rs.next()) {
                userLog.add(new UserLog(rs.getInt("userID"),
                        rs.getInt(2),
                        rs.getString("date"),
                        rs.getString("time")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
         
}
