/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IBusiness;
import Acq.IData;

/**
 *
 * @author Bruger
 */
public class BusinessFacade implements IBusiness {
    
    private IData data;
    private Business bus = new Business();
    
    @Override
    public void injectData(IData data) {
        this.data = data;
    }

    @Override
    public boolean login(String username, String password) {
        return bus.login(username, password);
    }
    

}
