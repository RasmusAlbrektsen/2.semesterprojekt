package Acq;

import java.sql.ResultSet;

public interface IData {

    //MEDICINE
    int getMedicineID(int caseID, String VNR);

    void saveMedicine(IMedicine medicine, int caseID);

    ResultSet getMedicine(int caseID);

    void deleteMedicine(IMedicine medicine);

    //LOGS
    ResultSet getCaseLog();

    ResultSet getUserLog();

    void saveToCaseLog(int userID, int caseID, String date, String time);

    void saveToUserLog(int userID, int changedUserID, String date, String time);

    void saveCreatedUserLog(int userID, int changedUserID, String date, String time);

    void saveCreatedCaseLog(int userID, int caseID, String date, String time);

    //USERS
    ResultSet getAllUsers();

    int saveUser(IUser user);

    void updateUser(IUser user);

    void deleteUser(IUser user);

    //CASES
    int saveCase(ICase aCase, String data);

    ResultSet getAllCases();

    String getCaseInfo(String directory);

    void updateCase(ICase aCase);

    void deleteCase(ICase aCase);

    //APPOINTMENTS
    void saveAppointment(IAppointment Appointment, int caseID);

    ResultSet getAppointments(int userID);

    int getAppointmentID(int userID, String date, String time);

    //DAILy NOTE
    void saveDailyNote(IDailyNote DailyNote, int caseID);

    int getDailyNoteID(int caseID, String note, String date);

    ResultSet getDailyNote(int caseID);
}
