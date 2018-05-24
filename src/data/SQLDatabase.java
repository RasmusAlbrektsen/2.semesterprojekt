package data;

import Acq.ICase;
import Acq.IDailyNote;
import Acq.IUser;
import Acq.IAppointment;
import Acq.IMedicine;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    //MEDICINE
    public int getMedicineID(int caseID, String VNR) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT medicine.medicineid FROM (Medicine INNER JOIN Associated on medicine.medicineid = associated.medicineid) WHERE caseid = " + caseID + " AND VNR = '" + VNR + "'");
            db.close();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void saveMedicine(IMedicine Medicine, int caseID) {
        String id;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO Medicine(vnr, dosage, name) VALUES ('" + Medicine.getVNR() + "','" + Medicine.getDosage() + "','" + Medicine.getName() + "')  RETURNING id;");
            id = rs.getString(1);
            st.execute("INSERT INTO Associated VALUES ('" + caseID + "','" + id + "');");
            db.close();
            System.out.println(rs.getString(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getMedicine(int caseID) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT medicine.medicineid, vnr, dosage, name FROM (medicine INNER JOIN associated on medicine.medicineid = associated.medicineid) WHERE caseID = " + caseID);
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //CASELOG

    public void saveToCaseLog(int userID, int caseID, String date, String time) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            st.execute("INSERT INTO caselog(userid, caseid, date, time) VALUES('" + userID + "','" + caseID + "','" + date + "','" + time + "');");
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveCreatedCaseLog(int userID, int caseID, String date, String time) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            st.execute("INSERT INTO caselog(userid, caseid, date, time) VALUES('" + userID + "','" + caseID + "','" + date + "','" + time + "');");
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getCaseLog() {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM caselog;");
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //USERLOG
    public void saveToUserLog(int userID, int changedUserID, String date, String time) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            st.execute("INSERT INTO userlog(userID, changeduserid, date, time) VALUES('" + userID + "','" + changedUserID + "','" + date + "','" + time + "');");
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveCreatedUserLog(int userID, int changedUserID, String date, String time) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            st.execute("INSERT INTO userlog(userID, changeduserid, date, time) VALUES('" + userID + "','" + changedUserID + "','" + date + "','" + time + "');");
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUserLog() {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM userlog;");
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //USERS 
    public int saveUser(IUser user) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO users"
                    + "(name, username, password, log, caseaccess, medicine, appointment) "
                    + "VALUES('" + user.getName()
                    + "', '" + user.getUsername()
                    + "', '" + user.getPassword()
                    + "', '" + user.getAdmin()
                    + "', '" + user.getCaseaccess()
                    + "', '" + user.getMedicine()
                    + "', '" + user.getAppointment() + "') RETURNING id;");
            db.close();
            rs.next();
            return rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void updateUser(IUser user) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            st.execute("UPDATE users SET "
                    + "name = '" + user.getName()
                    + "',username = '" + user.getUsername()
                    + "',password = '" + user.getPassword()
                    + "',log = '" + user.getAdmin()
                    + "',caseaccess = '" + user.getCaseaccess()
                    + "',medicine = '" + user.getMedicine()
                    + "',appointment = '" + user.getAppointment()
                    + "' WHERE id = " + user.getIDNumber());
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllUsers() {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteUser(IUser user) {
        List<Integer> appointmentIDs = new ArrayList();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM has WHERE userid = " + user.getIDNumber());
            while (rs.next()) {
                appointmentIDs.add(rs.getInt("appointmentID"));
            }
            st.execute("DELETE FROM has WHERE userid = " + user.getIDNumber());
            st.execute("DELETE FROM edited_user WHERE userid = " + user.getIDNumber() + " OR changeduserid = " + user.getIDNumber());
            st.execute("DELETE FROM works_on WHERE userid = " + user.getIDNumber());
            st.execute("DELETE FROM edited_case WHERE userid = " + user.getIDNumber());
            for (Integer appointmentID : appointmentIDs) {
                st.execute("DELETE FROM daily_note WHERE noteID = " + appointmentID);
            }
            st.execute("DELETE FROM users WHERE id = " + user.getIDNumber());
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //CASES
    public int saveCase(ICase aCase, String info) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO cases"
                    + "(creation_date, cpr, is_active) "
                    + "VALUES('" + aCase.getCreationDate()
                    + "', '" + aCase.getCPR()
                    + "', 'true') RETURNING caseid;");
            rs.next();
            int caseID = rs.getInt("caseid");
            st.execute("UPDATE cases "
                    + "SET case_directory = 'cases/case"
                    + rs.getInt("caseid") + ".txt" + "' WHERE caseid = '"
                    + caseID + "'");
            db.close();
            PrintWriter out = new PrintWriter("cases/case" + caseID + ".txt");
            out.println(info);
            out.close();
            return caseID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getCaseInfo(String directory) throws Exception {
        return new String(Files.readAllBytes(Paths.get(directory)));
    }

    public void updateCase(ICase aCase) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            st.execute("UPDATE cases SET "
                    + "creation_date = '" + aCase.getCreationDate()
                    + "',cpr = '" + aCase.getCPR()
                    + "',is_active = '" + aCase.isActive()
                    + "' WHERE caseid = " + aCase.getCaseNumber());
            db.close();
            PrintWriter out = new PrintWriter("cases/case" + aCase.getCaseNumber() + ".txt");
            out.println(aCase.getInfo());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllCases() {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cases");
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCase(ICase aCase) {
        List<Integer> medicineIDs = new ArrayList();
        List<Integer> dailyNoteIDs = new ArrayList();
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM has_a WHERE caseid = " + aCase.getCaseNumber());
            while (rs.next()) {
                dailyNoteIDs.add(rs.getInt("noteID"));
            }
            st.execute("DELETE FROM has_a WHERE caseid = " + aCase.getCaseNumber());
            ResultSet rs1 = st.executeQuery("SELECT * FROM associated WHERE caseid = " + aCase.getCaseNumber());
            while (rs1.next()) {
                medicineIDs.add(rs.getInt("medicineID"));
            }
            st.execute("DELETE FROM associated WHERE caseid = " + aCase.getCaseNumber());
            // Det her er fakin useless
            //st.execute("DELETE FROM edited_case WHERE caseid = " + aCase.getCaseNumber());
            st.execute("DELETE FROM cansee WHERE caseid = " + aCase.getCaseNumber());
            st.execute("DELETE FROM works_on WHERE caseid = " + aCase.getCaseNumber());
            for (Integer dailyNoteID : dailyNoteIDs) {
                st.execute("DELETE FROM daily_note WHERE noteID = " + dailyNoteID);
            }
            for (Integer medicineID : medicineIDs) {
                st.execute("DELETE FROM medicine WHERE medicineid = " + medicineID);
            }
            st.execute("DELETE FROM cases WHERE caseid = " + aCase.getCaseNumber());
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //APPOINTMENTS
    public ResultSet getAppointments(int userID) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT appointments.appointmentid, note, date, time FROM (appointments INNER JOIN has on appointments.appointmentid = has.appointmentid) WHERE userID = " + userID);
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getAppointmentID(int userID, String date, String time) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT appointments.appointmentid FROM (appointments INNER JOIN has on appointments.appointmentid = has.appointmentid) WHERE userID = " + userID + " AND Date = '" + date + "' AND time = '" + time + "'");
            db.close();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void saveAppointment(IAppointment Appointment, int userID) {
        String id;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO appointments(note, date, time) VALUES ('" + Appointment.getNote() + "','" + Appointment.getDate() + "','" + Appointment.getTime() + "')  RETURNING appointmentid;");
            rs.next();
            id = rs.getString(1);
            st.execute("INSERT INTO has VALUES ('" + id + "','" + userID + "');");
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //DAILYNOTE
    public void saveDailyNote(IDailyNote DailyNote, int caseID) {
        String id;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO Daily_note(note, date) VALUES ('" + DailyNote.getNote() + "','" + DailyNote.getDate() + "')  RETURNING NoteID;");
            rs.next();
            id = rs.getString(1);
            st.execute("INSERT INTO Has_A VALUES ('" + caseID + "','" + id + "');");
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getDailyNoteID(int caseID, String note, String date) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT daily_note.noteid, note, date FROM (daily_note INNER JOIN has_a on daily_note.noteid = has_a.noteid) WHERE caseID = " + caseID + " AND Date = '" + date + "' AND note = '" + note + "'");
            db.close();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet getDailyNote(int caseID) {
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT daily_note.noteid, note, date FROM (daily_note INNER JOIN has_a on daily_note.noteid = has_a.noteid) WHERE caseID = " + caseID);
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
