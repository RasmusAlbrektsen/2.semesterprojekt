/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IBusiness;
import Acq.ICalendar;
import Acq.ICase;
import Acq.IData;
import Acq.IUser;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bruger
 */
public class BusinessFacade implements IBusiness {
    
    private IData data;
    private Business bus = Business.getInstance();
    
    @Override
    public void injectData(IData data) {
        this.data = data;
    }

    @Override
    public boolean login(String username, String password) {
        return bus.login(username, password);
    }

    @Override
    public IUser getCurrentUser() {
        return bus.getCurrentUser();
    }

    @Override
    public ICalendar getCalendar(){
        return bus.getCalendar();
    }
    
    @Override
    public IData getData(){
        return data; 
    }
    @Override
    public void setUserMap(){
        bus.setUserMap();
    }

    @Override
    public void setCaseList() {
        bus.setCaseList();
    }

    @Override
    public List<ICase> getCases() {
        return bus.getCases();
    }
    
    @Override
    public Map<String, IUser> getUserMap() {
        return bus.getUserMap();
    }
    
    @Override
    public List<ICase> searchCases(Date date) {
        return bus.searchCases(date);
    }

    @Override
    public List<ICase> searchCases(String CPR) {
        return bus.searchCases(CPR);
    }

    @Override
    public List<ICase> searchCases(int id) {
        return bus.searchCases(id);
    }

    @Override
    public List<ICase> searchCases(Date date, String CPR) {
        return bus.searchCases(date, CPR);
    }

    @Override
    public List<ICase> searchCases(Date date, int id) {
        return bus.searchCases(date, id);
    }

    @Override
    public List<ICase> searchCases(String CPR, int id) {
        return bus.searchCases(CPR, id);
    }

    @Override
    public List<ICase> searchCases(Date date, String CPR, int id) {
        return bus.searchCases(date, CPR, id);
    }
    

}
