package Acq;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bruger
 */
public interface IData {
    //MEDICINE
    int  getMedicineID(int caseID, String VNR);
    void    saveMedicine(IMedicine medicine, int caseID);
    ResultSet getMedicine(int caseID);
    
    //LOGS
    ResultSet getCaseLog();
    void saveToCaseLog(int userID, int changedUserID, String date, String time);
    void saveToUserLog(int userID, int changedUserID, String date, String time);
    ResultSet getUserLog();
    
    //USERS
    ResultSet getAllUsers();
    void saveUser(IUser user);
    
    //CASES
    void saveCase(ICase aCase);
    ResultSet getAllCases();
    
    //APPOINTMENTS
    void saveAppointment(IAppointment Appointment, int caseID);
    ResultSet getAppointments(int userID);
    int getAppointmentID(int userID, String date, String time);
    
    //DAILy NOTE
    void saveDailyNote(IDailyNote DailyNote, int caseID);
    int getDailyNoteID(int caseID, String note, String date);
    ResultSet getDailyNote(int caseID);
}
