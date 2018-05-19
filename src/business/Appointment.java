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

    private String date;
    private String time;
    private String note;
    private int IDNum;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Appointment(String note, String date, String time, int UserID) throws ParseException {
        this.date = date;
        this.time = time;
        this.note = note;
        Business.getInstance().getData().saveAppointment(this, UserID);
        this.IDNum = Business.getInstance().getData().getAppointmentID(UserID, date, time);
    }
    
    public Appointment(int IDNum, String note, String date, String time ){
        this.date = date;
        this.time = time;
        this.note = note;
        this.IDNum = IDNum;
    }

    @Override
    public int getIDNum() {
        return IDNum;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }
    
    @Override
    public void setTime(String time) {
        this.note = time;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public String getNote() {
        return note;
    }
}
