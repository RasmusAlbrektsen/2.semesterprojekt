/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.IData;

/**
 *
 * @author nitra
 */
public class DataFacade implements IData{
 
    private SQLDatabase data = new SQLDatabase();
    
    public SQLDatabase getData(){
        return data;
    }
    
    
}
