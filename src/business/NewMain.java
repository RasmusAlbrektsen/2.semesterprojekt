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
        ICaseLogger cl = new CaseLogger(6, 38878949);
        data.saveCaseLogger(cl);
        ICaseLogger cl1 = data.loadCaseLogger();
        System.out.println(cl1);
    }
    
}
