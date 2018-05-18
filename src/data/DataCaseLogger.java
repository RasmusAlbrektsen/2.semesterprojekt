/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.ICaseLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bruger
 */
public class DataCaseLogger implements ICaseLogger {
   
    private String url = "jdbc:postgresql://horton.elephantsql.com:5432/ozylgaur";
    private String username = "ozylgaur";
    private String passwd = "yTyBQ5nyU85ChDPE0qdp2i4kUj5vIKa9";
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
    
    public void saveToCaseLog(int caseID, int userID, String date, String time){
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            st.execute("INSERT INTO caselog VALUES('UserID:" + userID + "','CaseID:" + caseID + "','" + date + "','" + time + "');");
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<DataLog> getLog() {

        List<DataLog> Log = new ArrayList<>();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM caselog;");
            db.close();
            while (rs.next()) {
                Log.add(new DataLog(rs.getString("UserID"),
                        rs.getString("CaseID"),
                        rs.getString("Date"),
                        rs.getString("Time")));
            }
            return Log;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    
    
     public List<DataLog> getCaseLogFromUser(String UserID){
        List<DataLog> Log = new ArrayList<>();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM caselog WHERE UserID = " + UserID + ";");
            db.close();
            while (rs.next()) {
                Log.add(new DataLog(rs.getString("UserID"),
                        rs.getString("CaseID"),
                        rs.getString("Date"),
                        rs.getString("Time")));
            }
            return Log;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     
      public List<DataLog> getCaseLogFromCase(String CaseID){
        List<DataLog> Log = new ArrayList<>();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM caselog WHERE CaseID = " + CaseID + ";");
            db.close();
            while (rs.next()) {
                Log.add(new DataLog(rs.getString("UserID"),
                        rs.getString("CaseID"),
                        rs.getString("Date"),
                        rs.getString("Time")));
            }
            return Log;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
      
    public List<DataLog> getCaseLogFromDate(String Date){
        List<DataLog> Log = new ArrayList<>();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM caselog WHERE Date = " + Date + ";");
            db.close();
            while (rs.next()) {
                Log.add(new DataLog(rs.getString("UserID"),
                        rs.getString("CaseID"),
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
