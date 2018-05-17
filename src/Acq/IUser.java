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
    boolean createAppointment(String date, String CPR, String note);
    boolean updateAppointment(IAppointment ap, Date date, String note);
    boolean removeAppointment(IAppointment ap);
    List<IAppointment> getAppointments();
   
    int getIDNumber();
}
