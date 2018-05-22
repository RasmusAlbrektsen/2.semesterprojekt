package Acq;

import java.util.Date;
import java.util.List;


public interface IUser {

    String getUsername();

    String getPassword();

    String getName();

    boolean getLog();

    boolean getMedicine();

    boolean getCaseaccess();

    boolean getAppointment();
    
    public void setIDNumber(int IDNumber);
    public void setCaseAccess(boolean caseAccess);
    public void setMedicine(boolean medicine);

    public void setLog(boolean log);
    public void setUsername(String username);
    public void setPassword(String password);
    public void setName(String name);
    
    boolean createAppointment(String note, String date, String time, int userID);
    boolean updateAppointment(IAppointment ap, String note, String date, String time);
    boolean removeAppointment(IAppointment ap);
    List<IAppointment> getAppointments();
   
    int getIDNumber();
    
    void updateUser();
}
