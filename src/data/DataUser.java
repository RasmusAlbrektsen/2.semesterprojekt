/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.IAppointment;
import Acq.ICase;
import Acq.IUser;
import java.util.List;

/**
 *
 * @author rasmusstamm
 */
public class DataUser implements IUser {

    private int IDNumber;
    private boolean caseAccess;
    private boolean medicine;
    private boolean appointment;
    private boolean log;
    private String username;
    private String password;
    private List<ICase> cases;
    private List<IAppointment> appointments;

    public int getIDNumber() {
        return IDNumber;
    }

    public boolean isCaseAccess() {
        return caseAccess;
    }

    public boolean isMedicine() {
        return medicine;
    }

    public boolean isAppointment() {
        return appointment;
    }

    public boolean isLog() {
        return log;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<ICase> getCases() {
        return cases;
    }

    public List<IAppointment> getAppointments() {
        return appointments;
    }

    
}
