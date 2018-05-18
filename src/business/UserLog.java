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
public class UserLog {
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
    
}
