package business;

import Acq.ICaseLogger;
import java.util.Date;

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

}
