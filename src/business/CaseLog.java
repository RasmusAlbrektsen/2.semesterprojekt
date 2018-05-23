/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.ICaseLog;

/**
 *
 * @author hejoo
 */
public class CaseLog implements ICaseLog {
    int userID;
    int caseID;
    String date;
    String time;
    
    public CaseLog(int userID, int caseID, String date, String time){
        this.caseID = caseID;
        this.date = date;
        this.time = time;
        this.userID = userID;
    }

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public int getCaseID() {
        return caseID;
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
        String s = "Case ID: " + caseID + " User ID: " + userID + " Date: " + date + " Time: " + time;
        return s;
    }
}
