package Acq;

import java.util.Date;
import java.util.List;

/**
 *
 * @author rasmusstamm
 */
public interface IUser {

    public boolean createAppointment(String date, String CPR, String note, int IDNum);
    public boolean updateAppointment(IAppointment ap, Date date, String note);
    public boolean removeAppointment(IAppointment ap);
    public List<IAppointment> getAppointments();
    public String getUsername();
    public String getPassword();
    public int getIDNumber();
}
