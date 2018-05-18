/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author hejoo
 */
public class DataLog {
    
    private String UserID;
    private String ChangedID;
    private String Date;
    private String Time;

    public DataLog(String UserID, String ChangedID, String Date, String Time) {
        this.UserID = UserID;
        this.ChangedID = ChangedID;
        this.Date = Date;
        this.Time = Time;
    }

  
}
