/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.ICase;
import Acq.IUser;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rasmusstamm
 */
public class SQLDatabase {
    
    String url = "jdbc:postgresql://horton.elephantsql.com:5432/zibscemz";
    String username = "zibscemz";
    String passwd = "7A1e6LvgBXjitm0pjGI3tIOf5aCpr0Qe";
    
    public void loadData() {
        
    }
    

    public List<DataMedicine> GetMedicine(String caseID){
        
        List<DataMedicine> Medicine = new ArrayList<>();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Medicine WHERE medicineid = (SELECT Associated.medicineid FROM Associated WHERE caseid = '" + caseID + "');");
            db.close();
            while (rs.next()) {
                Medicine.add(new DataMedicine(rs.getString("name"),
                          rs.getString("dosage"),
                          rs.getString("VNR")));

            }
          System.out.println(Medicine);
            return Medicine;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public void SaveNote(String note, String caseID, String Date){
        String id;
        try {
        Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO Daily_note(note) VALUES ('" + note + "','" + Date + "')  RETURNING id;");
            id = rs.getString(1);
            st.execute("INSERT INTO Has_A VALUES ('" + caseID + "','" + id + "');");
            db.close();
            System.out.println(rs.getString(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void SaveNote(String dosage, String caseID){
        String id;
        try {
        Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO Medicine(Dosage) VALUES ('" + dosage + "')  RETURNING id;");
            id = rs.getString(1);
            st.execute("INSERT INTO Associated VALUES ('" + caseID + "','" + id + "');");
            db.close();
            System.out.println(rs.getString(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
