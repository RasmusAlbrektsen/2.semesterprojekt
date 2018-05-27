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
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT medicine.medicineid FROM (Medicine INNER JOIN Associated on medicine.medicineid = associated.medicineid) WHERE caseid = ? AND VNR = ?");
            st.setInt(1, caseID);
            st.setString(2, VNR);
            ResultSet rs = st.executeQuery();
            db.close();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void saveMedicine(IMedicine medicine, int caseID) {
        int id;
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("INSERT INTO Medicine(vnr, dosage, name) VALUES (?,?,?)  RETURNING medicineid;");
            st.setString(1,medicine.getVNR());
            st.setString(2,medicine.getDosage());
            st.setString(3,medicine.getName());
            ResultSet rs = st.executeQuery();
            rs.next();
            id = rs.getInt(1);
            st = db.prepareStatement("INSERT INTO Associated VALUES (?,?);");
            st.setInt(1,caseID);
            st.setInt(2, id);
            st.execute();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getMedicine(int caseID) {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT medicine.medicineid, vnr, dosage, name FROM (medicine INNER JOIN associated on medicine.medicineid = associated.medicineid) WHERE caseID = ?");
            st.setInt(1, caseID);
            ResultSet rs = st.executeQuery();
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteMedicine(IMedicine medicine) {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("DELETE FROM associated WHERE medicineid = ?");
            st.setInt(1,medicine.getMedicineID());
            st.execute();
            st = db.prepareStatement("DELETE FROM medicine WHERE medicineid = ?");
            st.setInt(1,medicine.getMedicineID());
            st.execute();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //CASELOG

    public void saveToCaseLog(int userID, int caseID, String date, String time) {
        PreparedStatement st = null;
        int id;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("INSERT INTO caselog(userid, caseid, date, time) VALUES(?,?,?,?) RETURNING caselogid");
            st.setInt(1,userID);
            st.setInt(2,caseID);
            st.setString(3,date);
            st.setString(4, time);
            ResultSet rs = st.executeQuery();
            rs.next();
            id = rs.getInt("caselogid");
            st = db.prepareStatement("INSERT INTO edited_case VALUES (?,?,?)");
            st.setInt(1, userID);
            st.setInt(2, caseID);
            st.setInt(3, id);
            st.execute();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveCreatedCaseLog(int userID, int caseID, String date, String time) {
        PreparedStatement st = null;
        int id;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("INSERT INTO caselog(userid, caseid, date, time) VALUES(?,?,?,?) RETURNING caselogid");
            st.setInt(1, userID);
            st.setInt(2, caseID);
            st.setString(3, date);
            st.setString(4, time);
            ResultSet rs = st.executeQuery();
            rs.next();
            id = rs.getInt("caselogid");
            st = db.prepareStatement("INSERT INTO edited_case VALUES (?,?,?)");
            st.setInt(1, userID);
            st.setInt(2, caseID);
            st.setInt(3, id);
            st.execute();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getCaseLog() {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT * FROM caselog");
            ResultSet rs = st.executeQuery();
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //USERLOG
    public void saveToUserLog(int userID, int changedUserID, String date, String time) {
        PreparedStatement st = null;
        int id;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("INSERT INTO userlog(userID, changeduserid, date, time) VALUES(?,?,?,?) RETURNING userlogid");
            st.setInt(1, userID);
            st.setInt(2, changedUserID);
            st.setString(3, date);
            st.setString(4, time);
            ResultSet rs = st.executeQuery();
            rs.next();
            id = rs.getInt("userlogid");
            st = db.prepareStatement("INSERT INTO edited_user VALUES (?,?,?)");
            st.setInt(1, userID);
            st.setInt(2, changedUserID);
            st.setInt(3, id);
            st.execute();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveCreatedUserLog(int userID, int changedUserID, String date, String time) {
        PreparedStatement st = null;
        int id;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("INSERT INTO userlog(userID, changeduserid, date, time) VALUES(?,?,?,?) RETURNING userlogid");
            st.setInt(1, userID);
            st.setInt(2, changedUserID);
            st.setString(3, date);
            st.setString(4, time);
            ResultSet rs = st.executeQuery();
            rs.next();
            id = rs.getInt("userlogid");
            st = db.prepareStatement("INSERT INTO edited_case VALUES (?,?,?)");
            st.setInt(1, userID);
            st.setInt(2, changedUserID);
            st.setInt(3, id);
            st.execute();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUserLog() {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT * FROM userlog");
            ResultSet rs = st.executeQuery();
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //USERS 
    public int saveUser(IUser user) {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("INSERT INTO users(name, username, password, log, caseaccess, medicine, appointment) VALUES(?,?,?,?,?,?,?) RETURNING id");
            st.setString(1, user.getName());
            st.setString(2, user.getUsername());
            st.setString(3, user.getPassword());
            st.setBoolean(4, user.getAdmin());
            st.setBoolean(5, user.getCaseaccess());
            st.setBoolean(6, user.getMedicine());
            st.setBoolean(7, user.getAppointment());
            ResultSet rs = st.executeQuery();
            db.close();
            rs.next();
            return rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void updateUser(IUser user) {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("UPDATE users SET name = ?,username = ?, password = ?, log = ?, caseaccess = ?, medicine = ?, appointment = ? WHERE id = ?");
            st.setString(1, user.getName());
            st.setString(2, user.getUsername());
            st.setString(3, user.getPassword());
            st.setBoolean(4, user.getAdmin());
            st.setBoolean(5, user.getCaseaccess());
            st.setBoolean(6, user.getMedicine());
            st.setBoolean(7, user.getAppointment());
            st.setInt(8, user.getIDNumber());
            st.execute();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllUsers() {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT * FROM users");
            ResultSet rs = st.executeQuery();
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteUser(IUser user) {
        List<Integer> appointmentIDs = new ArrayList();
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT * FROM has WHERE userid = ?");
            st.setInt(1, user.getIDNumber());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                appointmentIDs.add(rs.getInt("appointmentID"));
            }
            st = db.prepareStatement("DELETE FROM has WHERE userid = ?");
            st.setInt(1, user.getIDNumber());
            st.execute();
            st = db.prepareStatement("DELETE FROM edited_user WHERE userid = ? OR changeduserid = ?");
            st.setInt(1, user.getIDNumber());
            st.setInt(2, user.getIDNumber());
            st.execute();
            st = db.prepareStatement("DELETE FROM works_on WHERE userid = ?");
            st.setInt(1, user.getIDNumber());
            st.execute();
            st = db.prepareStatement("DELETE FROM edited_case WHERE userid = ?");
            st.setInt(1, user.getIDNumber());
            st.execute();
            for (Integer appointmentID : appointmentIDs) {
                st = db.prepareStatement("DELETE FROM daily_note WHERE noteID = ?");
                st.setInt(1, appointmentID);
                st.execute();
            }
            st = db.prepareStatement("DELETE FROM users WHERE id = ?");
            st.setInt(1, user.getIDNumber());
            st.execute();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //CASES
    public int saveCase(ICase aCase, String info) {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("INSERT INTO cases(creation_date, cpr, is_active) VALUES(?,?,?) RETURNING caseid");
            st.setString(1, aCase.getCreationDate());
            st.setString(2, aCase.getCPR());
            st.setBoolean(3, true);
            ResultSet rs = st.executeQuery();
            rs.next();
            int caseID = rs.getInt("caseid");
            st = db.prepareStatement("UPDATE cases SET case_directory = ? WHERE caseid =?");
            st.setString(1, "cases/case" + rs.getInt("caseid") + ".txt");
            st.setInt(2, caseID);
            st.execute();
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
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("UPDATE cases SET creation_date = ?, cpr = ?, is_active = ? WHERE caseid = ?");
            st.setString(1, aCase.getCreationDate());
            st.setString(2, aCase.getCPR());
            st.setBoolean(3, aCase.isActive());
            st.setInt(4, aCase.getCaseNumber());
            st.execute();
            db.close();
            PrintWriter out = new PrintWriter("cases/case" + aCase.getCaseNumber() + ".txt");
            out.println(aCase.getInfo());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllCases() {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT * FROM cases");
            ResultSet rs = st.executeQuery();
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
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT * FROM has_a WHERE caseid = ?");
            st.setInt(1, aCase.getCaseNumber());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                dailyNoteIDs.add(rs.getInt("noteID"));
            }
            st = db.prepareStatement("DELETE FROM has_a WHERE caseid = ?");
            st.setInt(1, aCase.getCaseNumber());
            st.execute();
            st = db.prepareStatement("SELECT * FROM associated WHERE caseid = ?");
            st.setInt(1, aCase.getCaseNumber());
            ResultSet rs1 = st.executeQuery();
            while (rs1.next()) {
                medicineIDs.add(rs.getInt("medicineID"));
            }
            st = db.prepareStatement("DELETE FROM associated WHERE caseid = ?");
            st.setInt(1, aCase.getCaseNumber());
            st.execute();
            st = db.prepareStatement("DELETE FROM edited_case WHERE caseid = ?");
            st.setInt(1, aCase.getCaseNumber());
            st.execute();
            // Det her er fakin useless
            //st.execute("DELETE FROM edited_case WHERE caseid = " + aCase.getCaseNumber());
            st = db.prepareStatement("DELETE FROM cansee WHERE caseid = ?");
            st.setInt(1, aCase.getCaseNumber());
            st.execute();
            st = db.prepareStatement("DELETE FROM works_on WHERE caseid = ?");
            st.setInt(1, aCase.getCaseNumber());
            st.execute();
            for (Integer dailyNoteID : dailyNoteIDs) {
                st = db.prepareStatement("DELETE FROM daily_note WHERE noteID = ?");
                st.setInt(1, dailyNoteID);
                st.execute();
            }
            for (Integer medicineID : medicineIDs) {
                st = db.prepareStatement("DELETE FROM medicine WHERE medicineid = ?");
                st.setInt(1, medicineID);
                st.execute();
            }
            st.execute("DELETE FROM cases WHERE caseid = " + aCase.getCaseNumber());
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //APPOINTMENTS
    public ResultSet getAppointments(int userID) {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT appointments.appointmentid, note, date, time FROM (appointments INNER JOIN has on appointments.appointmentid = has.appointmentid) WHERE userID = ?");
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getAppointmentID(int userID, String date, String time) {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT appointments.appointmentid FROM (appointments INNER JOIN has on appointments.appointmentid = has.appointmentid) WHERE userID = ? AND Date = ? AND time = ?");
            st.setInt(1, userID);
            st.setString(2, date);
            st.setString(3, time);
            ResultSet rs = st.executeQuery();
            db.close();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void saveAppointment(IAppointment Appointment, int userID) {
        int id;
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("INSERT INTO appointments(note, date, time) VALUES (?,?,?)  RETURNING appointmentid;");
            st.setString(1, Appointment.getNote());
            st.setString(2, Appointment.getDate());
            st.setString(3, Appointment.getTime());
            ResultSet rs = st.executeQuery();
            rs.next();
            id = rs.getInt(1);
            st = db.prepareStatement("INSERT INTO has VALUES(?,?)");
            st.setInt(1, id);
            st.setInt(2, userID);
            st.execute();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //DAILYNOTE
    public void saveDailyNote(IDailyNote DailyNote, int caseID) {
        int id;
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("INSERT INTO Daily_note(note, date) VALUES (?,?)  RETURNING NoteID;");
            st.setString(1, DailyNote.getNote());
            st.setString(2, DailyNote.getDate());
            ResultSet rs = st.executeQuery();
            rs.next();
            id = rs.getInt(1);
            st = db.prepareStatement("INSERT INTO has_a VALUES (?,?)");
            st.setInt(1, caseID);
            st.setInt(2, id);
            st.execute();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getDailyNoteID(int caseID, String note, String date) {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT daily_note.noteid, note, date FROM (daily_note INNER JOIN has_a on daily_note.noteid = has_a.noteid) WHERE caseID = ? AND Date = ? AND note = ?");
            st.setInt(1, caseID);
            st.setString(2, date);
            st.setString(3, note);
            ResultSet rs = st.executeQuery();
            db.close();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResultSet getDailyNote(int caseID) {
        PreparedStatement st = null;
        try {
            Connection db = DriverManager.getConnection(url, username, passwd);
            st = db.prepareStatement("SELECT daily_note.noteid, note, date FROM (daily_note INNER JOIN has_a on daily_note.noteid = has_a.noteid) WHERE caseID = ?");
            st.setInt(1, caseID);
            ResultSet rs = st.executeQuery();
            db.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
