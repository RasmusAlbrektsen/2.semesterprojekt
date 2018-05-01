/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IAdminLogger;
import data.JSONDatabase;
import Acq.ICaseLogger;
import Acq.IMedicine;
import Acq.IUser;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        /*ICaseLogger cl = new CaseLogger(6, 38878949);
        data.saveCaseLogger(cl);
        ICaseLogger cl1 = data.loadCaseLogger();
        System.out.println(cl1);

        IAdminLogger al = new AdminLogger(7081708, 5809903);
        data.saveAdminLogger(al);
        IAdminLogger al1 = data.loadAdminLogger();
        System.out.println(al1);

        Map<String, IMedicine> medMap = new HashMap<>();
        medMap.put("Cancer cure", new Medicine("Cure for cancer", "two pills", "one pill"));
        medMap.put("Aids cure", new Medicine("Cure for aids", "two pills", "one pill"));
        data.saveMedicine(medMap);
        Map<String, IMedicine> medMap1 = data.getMedicine();
        for (String s : medMap1.keySet()) {
            System.out.println(medMap1.get(s));
        }*/
        Map<String, IUser> uMap = new HashMap<>();
        
        IUser u = new User("rasta17@gmail.com", "kys", 0);
        u.createCase("18037892");
        u.createAppointment(new Date(), "1289053", "This is a note");
        uMap.put(u.getUsername(), u);
        data.saveUser(uMap);
        
        Map<String, IUser> uMap2 = data.getUser();
        System.out.println(uMap2.toString());
    }
}