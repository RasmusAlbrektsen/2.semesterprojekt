package business;

import Acq.ICaseLog;

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

    /**
     * Getter for the attribute userID
     * @return integer
     */
    @Override
    public int getUserID() {
        return userID;
    }

    /**
     * Getter for the attribute caseID
     * @return integer
     */
    @Override
    public int getCaseID() {
        return caseID;
    }

    /**
     * Getter for the attribute date
     * @return String
     */
    @Override
    public String getDate() {
        return date;
    }

    /**
     * Getter for the attribute time
     * @return String
     */
    @Override
    public String getTime() {
        return time;
    }
    
    /**
     * Creates a string that contains information of the current object.
     * @return String 
     */
    @Override
    public String toString(){
        String s = "Case ID: " + caseID + " User ID: " + userID + " Date: " + date + " Time: " + time;
        return s;
    }
}
