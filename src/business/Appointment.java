 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IAppointment;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Bruger
 */
public class Appointment implements IAppointment{

    private Date date;
    private String cpr;
    private String note;
    private int IDNum;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Appointment(String date, String cpr, String note, int IDNum) throws ParseException {
        this.date = sdf.parse(date);
        this.cpr = cpr;
        this.note = note;
        this.IDNum = IDNum;
    }

    public int getIDNum() {
        return IDNum;
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
