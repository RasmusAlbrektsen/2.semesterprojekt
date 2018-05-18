package Acq;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bruger
 */
public interface IData {
    Map<String, IUser> getUsers();
    List<ICase> getCases();
    int  getMedicineID(int caseID);
    String  getMedicineVNR(int caseID);
    String  getMedicineName(int caseID);
    String  getMedicineDosage(int caseID);
    void    saveMedicine(String VNR, String dosage, String name, int caseID);
    ResultSet getCaseLog();
    ResultSet getAllUsers();
}
