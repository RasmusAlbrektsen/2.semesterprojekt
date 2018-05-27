package data;

import Acq.IAppointment;
import Acq.ICase;
import Acq.IDailyNote;
import Acq.IData;
import Acq.IMedicine;
import Acq.IUser;
import java.sql.ResultSet;

public class DataFacade implements IData {

    private SQLDatabase data = new SQLDatabase();

    @Override
    public ResultSet getCaseLog() {
        return data.getCaseLog();
    }

    @Override
    public ResultSet getAllUsers() {
        return data.getAllUsers();
    }

    @Override
    public int getMedicineID(int caseID, String VNR) {
        return data.getMedicineID(caseID, VNR);
    }

    @Override
    public void saveMedicine(IMedicine medicine, int caseID) {
        data.saveMedicine(medicine, caseID);
    }

    @Override
    public ResultSet getMedicine(int caseID) {
        return data.getMedicine(caseID);
    }
    
    @Override
    public void deleteMedicine(IMedicine medicine){
        data.deleteMedicine(medicine);
    }

    @Override
    public void saveToCaseLog(int userID, int caseID, String date, String time) {
        data.saveToCaseLog(userID, caseID, date, time);
    }

    @Override
    public void saveToUserLog(int userID, int changedUserID, String date, String time) {
        data.saveToUserLog(userID, changedUserID, date, time);
    }

    @Override
    public ResultSet getUserLog() {
        return data.getUserLog();
    }

    @Override
    public int saveUser(IUser user) {
       return data.saveUser(user);
    }

    @Override
    public int saveCase(ICase aCase, String info) {
        return data.saveCase(aCase, info);
    }

    @Override
    public ResultSet getAllCases() {
        return data.getAllCases();
    }

    @Override
    public void saveAppointment(IAppointment Appointment, int caseID) {
        data.saveAppointment(Appointment, caseID);
    }

    @Override
    public ResultSet getAppointments(int userID) {
        return data.getAppointments(userID);
    }

    @Override
    public int getAppointmentID(int userID, String date, String time) {
        return data.getAppointmentID(userID, date, time);
    }

    @Override
    public void saveDailyNote(IDailyNote DailyNote, int caseID) {
        data.saveDailyNote(DailyNote, caseID);
    }

    @Override
    public int getDailyNoteID(int caseID, String note, String date) {
        return data.getDailyNoteID(caseID, note, date);
    }

    @Override
    public ResultSet getDailyNote(int caseID) {
        return data.getDailyNote(caseID);
    }

    @Override
    public String getCaseInfo(String directory) {
        try {
            return data.getCaseInfo(directory);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void updateUser(IUser user) {
        data.updateUser(user);
    }

    @Override
    public void updateCase(ICase aCase) {
        data.updateCase(aCase);
    }

    @Override
    public void saveCreatedUserLog(int userID, int changedUserID, String date, String time) {
        data.saveCreatedUserLog(userID, changedUserID, date, time);
    }

    @Override
    public void saveCreatedCaseLog(int userID, int caseID, String date, String time) {
        data.saveCreatedCaseLog(userID, caseID, date, time);
    }

    @Override
    public void deleteCase(ICase aCase) {
        data.deleteCase(aCase);
    }

    @Override
    public void deleteUser(IUser user) {
        data.deleteUser(user);
    }
}
