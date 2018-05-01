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
public class User implements IUser{

    private int IDNumber;
    private boolean caseAccess;
    private boolean medicine;
    private boolean appointment;
    private boolean log;
    private String username;
    private String password;
    private List<Case> cases;
    private List<Appointment> appointments;

    public User(String username, String password, int accessLevel) {
        this.username = username;
        this.password = password;
        cases = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public boolean login(String username, String password) {
        return true;
    }

    public boolean createCase(String CPR) {
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
        return true;
    }

    public boolean updateAppointment(Appointment ap, Date date, String note) {
        return true;
    }

    public boolean removeAppointment(Appointment ap) {
        return true;
    }

    public boolean createDailyNote() {
        return true;
    }
    
    public boolean createUser(String un, String pw, int accessLevel){
        return true;
    }
    
    public boolean deleteUser(int IDNumber){
        return true;
    }
    
    public boolean updateUserAccess(int IDnum, boolean ca, boolean med, boolean ap, boolean log, boolean handleUsers){
        return true;
    }
}
