package business;

import java.util.Date;
import Acq.IUserLogger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserLogger implements IUserLogger{

    private int changedUserID;
    private int userID;
    private Date date;

    public UserLogger(int changedUserID, int userID) {
        this.changedUserID = changedUserID;
        this.userID = userID;
        date = new Date();
    }

    /**
     * Getter for the attribute changedUserID
     * @return integer
     */
    @Override
    public int getChangedUserID() {
        return changedUserID;
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
     * Getter for the attribute date
     * @return Date
     */
    @Override
    public Date getDate() {
        return date;
    }
    
    /**
     * Creates a string that contains information about the object.
     * @return String
     */
    @Override
    public String toString(){
        String s = "ChangedUser: " + changedUserID + " UserID: " + userID + " Date: " + date;
        return s;
    }
    
    /**
     * Gets a list of all the userLogs from the database
     * @return List
     */
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
