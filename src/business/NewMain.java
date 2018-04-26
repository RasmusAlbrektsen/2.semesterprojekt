/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.JSONDatabase;
import Acq.ICaseLogger;

/**
 *
 * @author Rasmus
 */
public class NewMain {

    private static JSONDatabase data;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        data = new JSONDatabase();
        ICaseLogger cl = new CaseLogger(5, 198092);
        data.saveCaseLogger(cl);
    }
    
}
