/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;

/**
 *
 * @author Bruger
 */
public class Appointment {

    private Date date;
    private String cpr;
    private String note;

    public Appointment(Date date, String cpr, String note) {
        this.date = date;
        this.cpr = cpr;
        this.note = note;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public String getCpr() {
        return cpr;
    }

    public String getNote() {
        return note;
    }
    
    
}
