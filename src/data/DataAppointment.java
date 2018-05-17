/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.IAppointment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rasmusstamm
 */
class DataAppointment implements IAppointment {

    private int IDNum;
    private Date date;
    private String cpr;
    private String note;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public DataAppointment(int IDNum, Date date, String cpr, String note) {
        this.IDNum = IDNum;
        this.date = date;
        this.cpr = cpr;
        this.note = note;
    }
    
    public DataAppointment(String date, String cpr, String note) throws ParseException{
        this.date = sdf.parse(date);
        this.cpr = cpr;
        this.note = note;
    }

    @Override
    public int getIDNum() {
        return IDNum;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getCpr() {
        return cpr;
    }

    @Override
    public String getNote() {
        return note;
    }

}
