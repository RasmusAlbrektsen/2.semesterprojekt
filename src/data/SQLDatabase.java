package data;

import Acq.ICase;
import Acq.IDailyNote;
import Acq.IUser;
import java.io.File;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLDatabase {

    String url = "jdbc:postgresql://horton.elephantsql.com:5432/zibscemz";
    String username = "zibscemz";
    String passwd = "7A1e6LvgBXjitm0pjGI3tIOf5aCpr0Qe";

    public void loadData() {

    }

    public void saveCase(ICase aCase) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO cases"
                    + "(creation_date, is_active) "
                    + "VALUES('" + aCase.getCreationDate()
                    + "', 'true') RETURNING caseid;");
            rs.next();
            int caseID = rs.getInt("caseid");
            st.execute("UPDATE cases "
                    + "SET case_directory = 'cases\\case"
                    + rs.getInt("caseid") + "' WHERE caseid = '"
                    + caseID + "'");
            db.close();

            PrintWriter out = new PrintWriter("case" + caseID + ".txt");
            out.println(aCase.isActive());
            out.println(aCase.getCreationDate());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DataMedicine> getMedicine(String caseID) {

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

    public void saveUser(IUser user) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            st.execute("INSERT INTO users"
                    + "(name, username, password, log, caseaccess, medicine, appointment) "
                    + "VALUES('" + user.getName()
                    + "', '" + user.getUsername()
                    + "', '" + user.getPassword()
                    + "', '" + user.getLog()
                    + "', '" + user.getCaseaccess()
                    + "', '" + user.getMedicine()
                    + "', '" + user.getAppointment() + "');");
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ICase> getCases() {
        List<ICase> cases = new ArrayList<>();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cases");
            ResultSet rs2;
            while (rs.next()) {
                st = db.createStatement();
                rs2 = st.executeQuery("SELECT * FROM Daily_Note WHERE noteid = (SELECT Has_A.noteid FROM Has_A WHERE caseid = '" + rs.getInt("caseid") + "');");
                List<IDailyNote> notes = new ArrayList<>();
                while (rs2.next()) {
                    notes.add(new DataDailyNote(rs2.getDate("date"), rs2.getString("note")));
                }
                File caseFile = new File(rs.getString("case_directory"));
                cases.add(new DataCase(rs.getInt("caseid"), rs.getDate("creation_date"), notes));
            }
            db.close();
            return cases;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, IUser> getUsers() {
        Map<String, IUser> users = new HashMap<>();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            db.close();
            while (rs.next()) {
                users.put(rs.getString("username"), new DataUser(rs.getInt("id"), rs.getBoolean("caseaccess"), rs.getBoolean("medicine"), rs.getBoolean("appointment"), rs.getBoolean("log"), rs.getString("username"), rs.getString("password")));
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveNote(String note, String caseID, String Date) {
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

    public void saveMedicine(String dosage, String caseID) {
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
