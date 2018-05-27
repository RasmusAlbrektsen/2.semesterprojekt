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

    /**
     * Setter for the attribute data
     * @param data
     */
    public void setData(IData data) {
        this.data = data;
    }

    /**
     * Getter that constructs an instance of Business if it's null
     * @return Business
     */
    public static Business getInstance() {
        if (business == null) {
            business = new Business();
        }
        return business;
    }

    /**
     * Logs in if the username is a key in the map, and the password fits the user objects password
     * @param username
     * @param password
     * @return boolean
     */
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
     * Getter for the currentUser attribute
     * @return IUser
     */
    public IUser getCurrentUser() {
        return currentUser;
    }

    /**
     * Getter for the calendar attribute
     * @return ICalendar
     */
    public ICalendar getCalendar() {
        return calendar;
    }

    /**
     * Setter for the userMap map.
     * Gets the data for the SQL Database
     */
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

    /**
     * Setter for the allCases list.
     * Gets the data from the SQL Database
     */
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

    /**
     * Getter for the list allCases
     * @return List
     */
    public List<ICase> getCases() {
        return allCases;
    }

    /**
     * Getter for the attribute data
     * @return IData
     */
    public IData getData() {
        return data;
    }

    /**
     * Getter for the map userMap
     * @return Map
     */
    public Map<String, IUser> getUserMap() {
        return userMap;
    }

    /**
     * Getter for the list caseLog
     * @return List
     */
    public List<ICaseLog> getCaseLog() {
        return caseLog;
    }

    /**
     * Getter for the list userLog
     * @return List
     */
    public List<IUserLog> getUserLog() {
        return userLog;
    }

    /**
     * Saves a new case, by calling the case constructor
     * @param CPR
     * @param info
     */
    public void saveCase(String CPR, String info) {
        new Case(CPR, info).saveCase(getCurrentUser().getIDNumber());
    }
    
    /**
     * updates an already saved case.
     * @param aCase
     * @param info
     */
    public void updateCase(ICase aCase, String info){
        aCase.updateCase(currentUser.getIDNumber(),info);
    }
    
    /**
     * Deletes a case.
     * @param aCase
     */
    public void deleteCase(ICase aCase){
        aCase.deleteCase(currentUser.getIDNumber());
    }
    
    /**
     * Saves a DailyNote on the case with the specified caseID, with the string as the note
     * @param note
     * @param caseID
     */
    public void saveDailyNote(String note, int caseID){
        new DailyNote(note).pushDailyNote(caseID, getCurrentUser().getIDNumber());
    }
    
    /**
     * Saves medicine by constructing a new medicine
     * @param name
     * @param VNR
     * @param dosage
     * @param caseID
     */
    public void saveMedicine(String name, String VNR, String dosage, int caseID){
        new Medicine(name, VNR, dosage).pushMedicine(caseID, getCurrentUser().getIDNumber());
    }
    
    /**
     * Saves a user by constructing a new user.
     * @param name
     * @param username
     * @param password
     */
    public void saveUser(String name, String username, String password) {
        new User(name, username, password).saveUser(getCurrentUser().getIDNumber());
    }

    /**
     * Searches for cases with the specific creationDate as the parameter.
     * @param date
     * @return List
     */
    public List<ICase> searchCases(Date date) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCreationDate().equals(calendar.formatToString(date))) {
                cases.add(aCase);
            }
        }
        return cases;
    }

    /**
     * Searches for cases with the specific CPR as the parameter.
     * @param CPR
     * @return List
     */
    public List<ICase> searchCases(String CPR) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCPR().equals(CPR)) {
                cases.add(aCase);
            }
        }
        return cases;
    }

    /**
     * Searches for cases with the specific id as the parameter.
     * @param id
     * @return List
     */
    public List<ICase> searchCases(int id) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCaseNumber() == id) {
                cases.add(aCase);
            }
        }
        return cases;
    }

    /**
     * Searches for cases with the specific creationDate and CPR as the parameters.
     * @param date
     * @param CPR
     * @return List
     */
    public List<ICase> searchCases(Date date, String CPR) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCreationDate().equals(calendar.formatToString(date)) && aCase.getCPR().equals(CPR)) {
                cases.add(aCase);
            }
        }
        return cases;
    }
    
/**
 * Searches for cases with the specific data and id as the parameters
 * @param date
 * @param id
 * @return List
 */
    public List<ICase> searchCases(Date date, int id) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCreationDate().equals(calendar.formatToString(date)) && aCase.getCaseNumber() == id) {
                cases.add(aCase);
            }
        }
        return cases;
    }

    /**
     * Searches for cases with the specific CPR and id as the parameters
     * @param CPR
     * @param id
     * @return List
     */
    public List<ICase> searchCases(String CPR, int id) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCPR().equals(CPR) && aCase.getCaseNumber() == id) {
                cases.add(aCase);
            }
        }

        return cases;
    }

    /**
     * Searches for cases with the specific data, CPR and id as the parameters.
     * @param date
     * @param CPR
     * @param id
     * @return List
     */
    public List<ICase> searchCases(Date date, String CPR, int id) {
        List<ICase> cases = new ArrayList<>();
        for (ICase aCase : allCases) {
            if (aCase.getCreationDate().equals(calendar.formatToString(date)) && aCase.getCPR().equals(CPR) && aCase.getCaseNumber() == id) {
                cases.add(aCase);
            }
        }
        return cases;
    }
    
    /**
     * Setter for the list caseLog, getting the data from the SQL database
     */
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
     
    /**
     * Setter for the list userLog, getting the data from the SQL database
     */
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
