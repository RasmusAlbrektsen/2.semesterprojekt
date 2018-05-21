package business;

import Acq.IAppointment;
import Acq.IUser;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author Bruger
 */
public class User implements IUser {

    private int IDNumber;
    private boolean caseAccess;
    private boolean medicine;
    private boolean appointment;
    private boolean log;
    private String username;
    private String password;
    private String name;
    private List<IAppointment> appointments;

    public User(int IDNumber, String name, String username, String password, boolean log, boolean medicine, boolean appointment, boolean caseAccess) {
        this.IDNumber = IDNumber;
        this.caseAccess = caseAccess;
        this.medicine = medicine;
        this.appointment = appointment;
        this.log = log;
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
    
    public User(int IDNumber, String name, String username, String password, int accessLevel){
        this.IDNumber = IDNumber;
        this.name = name;
        this.username = username;
        this.password = password;
        appointments = new ArrayList<>();

        switch (accessLevel) {
            case 1:
                appointment = true;
                caseAccess = false;
                medicine = false;
                log = false;
                break;
            case 2:
                appointment = true;
                caseAccess = true;
                medicine = true;
                log = false;
                break;
            case 3:
                appointment = true;
                caseAccess = true;
                medicine = true;
                log = true;
                break;
        } 
    }

   


    /*public boolean login(String username, String password) {
        return true;
    }

    public boolean createCase(String CPR) {
        //cases.add(new Case(CPR));
        return true;
    }

    public boolean updateCase(int caseNumber) {
        return true;
    }

    public boolean createMedicine(String name, String amount, String dose) {
        return true;
    }

    public boolean updateMedicine(Medicine medicine, String amount, String dose) {
        return true;
    }

    public boolean createOffer(String residence, Date startDate) {
        return true;
    }

    public boolean createOffer(String residence, Date startDate, Date endDate) {
        return true;
    } */

    @Override
    public boolean createAppointment(String note, String date, String time, int userID) {
        try {
            appointments.add(new Appointment(note, date, time, userID));
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean updateAppointment(IAppointment ap, String note, String date, String time) {
        for (IAppointment appointment : appointments) {
            if(appointment == ap) {
               appointment.setDate(date);
               appointment.setTime(time);
               appointment.setNote(note);
               return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAppointment(IAppointment ap) {
         for (IAppointment appointment : appointments) {
            if(appointment == ap) {
               appointments.remove(ap);
               return true;
            }
        }
        return false;
    }

    @Override
    public List<IAppointment> getAppointments() {
        return appointments;
    }
    
    
    /*

    public boolean createUser(String un, String pw, int accessLevel) {
        return true;
    }

    public boolean deleteUser(int IDNumber) {
        return true;
    }

    public boolean updateUserAccess(int IDnum, boolean ca, boolean med, boolean ap, boolean log, boolean handleUsers) {
        return true;
    }*/
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean getLog() {
        return log;
    }

    @Override
    public boolean getMedicine() {
        return medicine;
    }

    @Override
    public boolean getCaseaccess() {
        return caseAccess;
    }

    @Override
    public boolean getAppointment() {
        return appointment;
    }
  
    public int getIDNumber() {
        return IDNumber;
    }
    
    public void pushUser() {
        Business.getInstance().getData().saveUser(this);
    }
}
