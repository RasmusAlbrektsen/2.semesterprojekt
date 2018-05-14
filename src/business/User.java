/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IUser;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
//    private List<Case> cases;
    private List<Appointment> appointments;

    public User(String username, String password, int accessLevel, int IDNumber) {
        this.username = username;
        this.password = password;
        this.IDNumber = IDNumber;
        //cases = new ArrayList<>();
        appointments = new ArrayList<>();
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

    public boolean createAppointment(String date, String CPR, String note, int IDNum) {
        try {
            appointments.add(new Appointment(date, CPR, note, IDNum));
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean updateAppointment(Appointment ap, Date date, String note) {
        for (Appointment appointment : appointments) {
            if(appointment == ap) {
               appointment.setDate(date);
               appointment.setNote(note);
               return true;
            }
        }
        return false;
    }

    public boolean removeAppointment(Appointment ap) {
         for (Appointment appointment : appointments) {
            if(appointment == ap) {
               appointments.remove(ap);
               return true;
            }
        }
        return false;
    }

    public List<Appointment> getAppointments() {
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

    public int getIDNumber() {
        return IDNumber;
    }
    
    
}
