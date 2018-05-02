/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.IAdminLogger;
import java.util.Date;

/**
 *
 * @author Bruger
 */
public class DataAdminLogger extends MotherLogger implements IAdminLogger{
    
    private int changedUserID;
    private int userID;
    private Date date;
    
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
