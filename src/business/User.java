/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    //private List<Case> cases;
    //private List<Appointment> appointments;

    public User(String name, String username, String password, boolean log, boolean medicine, boolean appointment, boolean caseAccess) {
        this.caseAccess = caseAccess;
        this.medicine = medicine;
        this.appointment = appointment;
        this.log = log;
        this.username = username;
        this.password = password;
        this.name = name;
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
    }

    public boolean createAppointment(Date date, String CPR, String note) {
        //appointments.add(new Appointment(date, CPR, note));
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
}
