package business;

import Acq.ICaseLogger;
import data.DataLog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class CaseLogger implements ICaseLogger {

    private int caseNumber;
    private int userIDNumber;
    private Date date;

    public CaseLogger(int caseNumber, int userIDNumber) {
        this.caseNumber = caseNumber;
        this.userIDNumber = userIDNumber;
        this.date = new Date();
    }

    @Override
    public int getCaseNumber() {
        return caseNumber;
    }

    @Override
    public int getUserID() {
        return userIDNumber;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        String s = "CaseNum: " + caseNumber + " UserID: " + userIDNumber + " Date: " + date;
        return s;
    }
    
    public List<CaseLog> getCaseLogs() {

        List<CaseLog> Log = new ArrayList<>();
        ResultSet rs = Business.getInstance().getData().getCaseLog();
           try{
            while (rs.next()) {
                Log.add(new CaseLog(rs.getInt("UserID"),
                        rs.getInt("CaseID"),
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
