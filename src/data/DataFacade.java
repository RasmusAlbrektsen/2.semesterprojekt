/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.ICase;
import Acq.IData;
import Acq.IUser;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nitra
 */
public class DataFacade implements IData{
 
    private SQLDatabase data = new SQLDatabase();

    @Override
    public Map<String, IUser> getUsers() {
        return data.getUsers();
    }

    @Override
    public List<ICase> getCases() {
        return data.getCases();
    }

    @Override
    public int getMedicineID(int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMedicineVNR(int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMedicineName(int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMedicineDosage(int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveMedicine(String VNR, String dosage, String name, int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getCaseLog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAllUsers() {
        return data.getAllUsers();
    }

    
    
}
