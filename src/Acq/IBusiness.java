package Acq;

import business.Business;


/**
 *
 * @author Bruger
 */
public interface IBusiness {
    
    public void injectData(IData data);
    boolean login(String username, String password);
    IUser getCurrentUser();
    ICalendar getCalendar();
    Business getBus();
    IData getData();
}
