/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;
import Acq.IUserLogger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rasmusstamm
 */
public class UserLogger implements IUserLogger{

    private int changedUserID;
    private int userID;
    private Date date;

    public UserLogger(int changedUserID, int userID) {
        this.changedUserID = changedUserID;
        this.userID = userID;
        date = new Date();
    }

    @Override
    public int getChangedUserID() {
        return changedUserID;
    }

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public Date getDate() {
        return date;
    }
    
    @Override
    public String toString(){
        String s = "ChangedUser: " + changedUserID + " UserID: " + userID + " Date: " + date;
        return s;
    }
    public List<UserLog> getUserLogs() {

        List<UserLog> Log = new ArrayList<>();
        ResultSet rs = Business.getInstance().getData().getCaseLog();
           try{
            while (rs.next()) {
                Log.add(new UserLog(rs.getInt("UserID"),
                        rs.getInt("ChangedUserID"),
                        rs.getString("Date"),
                        rs.getString("Time")));
            }
            return Log;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
