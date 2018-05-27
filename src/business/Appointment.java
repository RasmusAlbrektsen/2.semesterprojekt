package business;

import Acq.IAppointment;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    /**
     * Getter method for the attribute IDNum
     * @return integer
     */
    @Override
    public int getIDNum() {
        return IDNum;
    }

    /**
     * Setter for the attribute date
     * @param date
     */
    @Override
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Setter for the attribute note
     * @param note
     */
    @Override
    public void setNote(String note) {
        this.note = note;
    }
    
    /**
     * Setter for the attribute time
     * @param time
     */
    @Override
    public void setTime(String time) {
        this.note = time;
    }

    /**
     * Getter for the attribute date
     * @return String
     */
    @Override
    public String getDate() {
        return date;
    }

    /**
     * Getter for the attribute time
     * @return String
     */
    @Override
    public String getTime() {
        return time;
    }

    /**
     * Getter for the attribute note
     * @return String
     */
    @Override
    public String getNote() {
        return note;
    }
}
