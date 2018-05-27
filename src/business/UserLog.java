package business;

import Acq.IUserLog;

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

    /**
     * Getter for the attribute userID 
     * @return integer
     */
    @Override
    public int getUserID() {
        return userID;
    }

    /**
     * Getter for the attribute changeUserID
     * @return 
     */
    @Override
    public int getChangeUserID() {
        return changeUserID;
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
     * Creates a string that contains information about the object.
     * @return String
     */
    @Override
    public String toString(){
        String s = "ChangedUser: " + changeUserID + " UserID: " + userID + " Date: " + date + " Time: " + time;
        return s;
    }
}
