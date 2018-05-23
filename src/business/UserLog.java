/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IUserLog;

/**
 *
 * @author hejoo
 */
public class UserLog implements IUserLog {
    int userID;
    int changeUserID;
    String date;
    String time;

    public UserLog(int userID, int changeUserID, String date, String time) {
        this.userID = userID;
        this.changeUserID = changeUserID;
        this.date = date;
        this.time = time;
    }

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public int getChangeUserID() {
        return changeUserID;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public String getTime() {
        return time;
    }
    
    @Override
    public String toString(){
        String s = "ChangedUser: " + changeUserID + " UserID: " + userID + " Date: " + date + " Time: " + time;
        return s;
    }
}
