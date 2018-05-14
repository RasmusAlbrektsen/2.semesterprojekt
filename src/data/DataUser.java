/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.IAppointment;
import Acq.ICase;
import Acq.IUser;
import java.util.Date;
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
    private List<IAppointment> appointments;

    public DataUser(int IDNumber, String username, String password){
        this.IDNumber = IDNumber;
        this.username = username;
        this.password = password;
    }
    
    /*@Override
    public boolean createCase(String CPR) {
        return true;
    }

    @Override
    public boolean createAppointment(Date date, String CPR, String note) {
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

}
