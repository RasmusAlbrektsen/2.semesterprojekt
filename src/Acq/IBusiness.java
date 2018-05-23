package Acq;

import java.util.ArrayList;
import java.util.Date;
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
    List<ICaseLog> getCaseLog();
    List<IUserLog> getUserLog();
    Map<String, IUser> getUserMap();
    void setUserMap();
    void setCaseList();
    void setCaseLogs();
    void setUserLogs();
    List<ICase> getCases();
    List<ICase> searchCases(Date date);
    List<ICase> searchCases(String CPR);
    List<ICase> searchCases(int id);
    List<ICase> searchCases(Date date, String CPR);
    List<ICase> searchCases(Date date, int id);
    List<ICase> searchCases(String CPR, int id);
    List<ICase> searchCases(Date date, String CPR, int id);
    void saveCase(String CPR, String info);
    void updateCase(ICase aCase, String info);
    void saveUser(String name, String username, String password);
}
