package Acq;

import java.util.List;
import java.util.Map;


/**
 *
 * @author Bruger
 */
public interface IBusiness {
    
    public void injectData(IData data);
    boolean login(String username, String password);
    IUser getCurrentUser();
    ICalendar getCalendar();
    IData getData();
    void setUserMap();
    void setCaseList();
    List<ICase> getCases();
}
