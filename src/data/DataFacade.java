/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.ICase;
import Acq.IData;
import Acq.IUser;
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

    
    
}
