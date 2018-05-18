/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author hejoo
 */
public class CaseLog {
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
}
