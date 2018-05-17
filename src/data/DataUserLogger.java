/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;
import Acq.IUserLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruger
 */
public class DataUserLogger implements IUserLogger{
    
    private String url = "jdbc:postgresql://horton.elephantsql.com:5432/vyqzasrf";
    private String username = "vyqzasrf";
    private String passwd = "9x84zI_uCZ854jTf8T304wNGsNj8XipH";
    private int changedUserID;
    private int userID;
    private Date date;
    
    @Override
    public int getChangedUserID() {
        return changedUserID;
    }

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public Date getDate() {
        return date;
    }
    
    @Override
    public String toString(){
        String s = "ChangedUser: " + changedUserID + " UserID: " + userID + " Date: " + date;
        return s;
    }
    
    public void saveToCaseLog(int userID, int changedUserID, String date, String time){
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            st.execute("INSERT INTO caselog VALUES('UserID:" + userID + "','UserID:" + changedUserID + "','" + date + "','" + time + "');");
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
    
    
     public List<DataLog> getUserLogFromUser(String UserID){
        List<DataLog> Log = new ArrayList<>();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM userlog WHERE UserID = " + UserID + ";");
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
     
      public List<DataLog> getUserLogFromChangedUser(String ChangedUserID){
        List<DataLog> Log = new ArrayList<>();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM userlog WHERE ChangedUserID = " + ChangedUserID + ";");
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
      
    public List<DataLog> getUserLogFromDate(String Date){
        List<DataLog> Log = new ArrayList<>();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM userlog WHERE Date = " + Date + ";");
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
