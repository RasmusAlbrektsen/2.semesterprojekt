/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.ICaseLogger;
import data.DataCaseLogger;
import java.io.Serializable;
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

}
