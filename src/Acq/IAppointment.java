package Acq;

public interface IAppointment {
    public int getIDNum();
    public void setDate(String date);
    public void setNote(String note);
    public void setTime(String time);
    public String getDate();
    public String getTime();
    public String getNote();
}
