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
public interface IAppointment {
    public int getIDNum();
    public void setDate(Date date);
    public void setNote(String note);
    public Date getDate();
    public String getCpr();
    public String getNote();
}
