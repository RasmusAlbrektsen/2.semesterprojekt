package business;

import Acq.IAppointment;
import Acq.IUser;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class User implements IUser {

    private int IDNumber;
    private boolean caseAccess;
    private boolean medicine;
    private boolean appointment;
    private boolean admin;
    private String username;
    private String password;
    private String name;
    private List<IAppointment> appointments;

    /**
     * Constructor for when loading a user from the database
     * @param IDNumber
     * @param name
     * @param username
     * @param password
     * @param log
     * @param medicine
     * @param appointment
     * @param caseAccess 
     */
    public User(int IDNumber, String name, String username, String password, boolean log, boolean medicine, boolean appointment, boolean caseAccess) {
        this.IDNumber = IDNumber;
        this.caseAccess = caseAccess;
        this.medicine = medicine;
        this.appointment = appointment;
        this.admin = log;
        this.username = username;
        this.password = password;
        this.name = name;
        this.IDNumber = IDNumber;
        appointments = new ArrayList<>();
        ResultSet rs = Business.getInstance().getData().getAppointments(IDNumber);
        try {
            while (rs.next()) {
                appointments.add(new Appointment(rs.getInt("appointmentid"),
                        rs.getString("note"),
                        rs.getString("date"),
                        rs.getString("time")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor for when making a new user object
     * @param name
     * @param username
     * @param password 
     */
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        appointments = new ArrayList<>();
    }

    /**
     * Adds a new appointment to the user. 
     * @param note
     * @param date
     * @param time
     * @param userID
     * @return 
     */
    @Override
    public boolean createAppointment(String note, String date, String time, int userID) {
        try {
            appointments.add(new Appointment(note, date, time, userID));
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    /**
     * Not yet implemented.
     * @param ap
     * @param note
     * @param date
     * @param time
     * @return 
     */
    @Override
    public boolean updateAppointment(IAppointment ap, String note, String date, String time) {
        for (IAppointment appointment : appointments) {
            if (appointment == ap) {
                appointment.setDate(date);
                appointment.setTime(time);
                appointment.setNote(note);
                return true;
            }
        }
        return false;
    }

    /**
     * Not yet implemented.
     * @param ap
     * @return 
     */
    @Override
    public boolean removeAppointment(IAppointment ap) {
        for (IAppointment appointment : appointments) {
            if (appointment == ap) {
                appointments.remove(ap);
                return true;
            }
        }
        return false;
    }

    /**
     * Getter for the list appointments
     * @return List
     */
    @Override
    public List<IAppointment> getAppointments() {
        return appointments;
    }

    /**
     * Getter for the attribute username
     * @return String
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Getter for the attribute password
     * @return String
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Getter for the attribute name
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter for the attribute admin
     * @return boolean
     */
    @Override
    public boolean getAdmin() {
        return admin;
    }

    /**
     * Getter for the attribute medicine
     * @return boolean
     */
    @Override
    public boolean getMedicine() {
        return medicine;
    }

    /**
     * Getter for the attribute caseAccess
     * @return boolean
     */
    @Override
    public boolean getCaseaccess() {
        return caseAccess;
    }

    /**
     * Getter for the attribute appointment
     * @return boolean
     */
    @Override
    public boolean getAppointment() {
        return appointment;
    }

    /**
     * Getter for the attribute IDNumber
     * @return integer
     */
    @Override
    public int getIDNumber() {
        return IDNumber;
    }

    /**
     * Setter for the attribute IDNumber
     * @param IDNumber 
     */
    @Override
    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    /**
     * Setter for the attribute caseAccess
     * @param caseAccess 
     */
    @Override
    public void setCaseAccess(boolean caseAccess) {
        this.caseAccess = caseAccess;
    }

    /**
     * Setter for the attribute medicine
     * @param medicine 
     */
    @Override
    public void setMedicine(boolean medicine) {
        this.medicine = medicine;
    }

    /**
     * Setter for the attribute admin
     * @param log
     */
    @Override
    public void setLog(boolean log) {
        this.admin = log;
    }

    /**
     * Setter for the attribute username
     * @param username 
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter for the attribute password
     * @param password 
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setter for the attribute name
     * @param name 
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the attribute appointment
     * @param appointment 
     */
    @Override
    public void setAppointment(boolean appointment) {
        this.appointment = appointment;
    }

    /**
     * Updates the user object, and saves the parameter to the userlog.
     * @param currentUserID 
     */
    @Override
    public void updateUser(int currentUserID) {
        Business.getInstance().getData().updateUser(this);
        Business.getInstance().getData().saveToUserLog(currentUserID, IDNumber,
                Business.getInstance().getCalendar().getTodaysDateString(),
                Business.getInstance().getCalendar().getTodaysTimeString());
    }

    /**
     * Saves the user, and saves the IDNumber to the userlog
     * @param currentUserID 
     */
    @Override
    public void saveUser(int currentUserID) {
        IDNumber = Business.getInstance().getData().saveUser(this);
        Business.getInstance().getData().saveCreatedUserLog(currentUserID,
                IDNumber,
                Business.getInstance().getCalendar().getTodaysDateString(),
                Business.getInstance().getCalendar().getTodaysTimeString());

    }

    /**
     * Deletes the currentUser, and saves the currentUserID to the database in the userlog
     * @param currentUserID 
     */
    @Override
    public void deleteUser(int currentUserID) {
        Business.getInstance().getData().saveToUserLog(currentUserID,
                IDNumber,
                Business.getInstance().getCalendar().getTodaysDateString(),
                Business.getInstance().getCalendar().getTodaysTimeString());
        Business.getInstance().getData().deleteUser(this);
    }
    
}
