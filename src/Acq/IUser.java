/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import java.util.Date;

/**
 *
 * @author rasmusstamm
 */
public interface IUser {

    public boolean createCase(String CPR);

    public boolean createAppointment(Date date, String CPR, String note);

    public String getUsername();

    public String getPassword();
}
