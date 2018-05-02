/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.ICaseLogger;
import business.CaseLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruger
 */
public class DataCaseLogger extends MotherLogger implements ICaseLogger {

    private int caseNumber;
    private int userIDNumber;
    private Date date;

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
