/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;
import Acq.IUserLogger;

/**
 *
 * @author rasmusstamm
 */
public class AdminLogger implements IUserLogger{

    private int changedUserID;
    private int userID;
    private Date date;

    public AdminLogger(int changedUserID, int userID) {
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
}
