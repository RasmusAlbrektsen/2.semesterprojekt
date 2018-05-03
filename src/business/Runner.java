/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IAdminLogger;
import Acq.IAppointment;
import Acq.ICase;
import data.JSONDatabase;
import Acq.ICaseLogger;
import Acq.IMedicine;
import Acq.IUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Rasmus
 */
public class Runner {

    private static JSONDatabase data;

    /**
     * @param args the command line arguments
     */
    private Map<String, IUser> users;
    private List<ICase> cases = new ArrayList<>();
    private List<IAppointment> appointments = new ArrayList<>();
    private Scanner s;
    private IUser currentUser;

    public void run() {
        data = new JSONDatabase();
        s = new Scanner(System.in);
        
        Map<String, IUser> users2 = new HashMap<>();
        IUser u = new User("rasta", "kys", 0, 28);
        List<ICase> cases2 = new ArrayList<>();
        cases.add(new Case("81272739", 28));
        cases.add(new Case("918764", 28));
        List<IAppointment> appointments2 = new ArrayList<>();
        appointments2.add(new Appointment(new Date(), "2881823", "This is a note", 28));
        users2.put(u.getUsername(), u);
        data.saveUser(users2);
        users = data.getUsers();
        
        Scanner s = new Scanner(System.in);
        boolean loggedIn = false;
        String user;
        String pass;
        while (!loggedIn) {
            user = s.nextLine();
            pass = s.nextLine();
            if (login(user, pass)) {
                currentUser = users.get(user);
                loggedIn = true;
            }
        }
    }

    public boolean login(String username, String password) {
        if (users.containsKey(username)) {
            if (password.equals(users.get(username).getPassword())) {
                System.out.println("logged in as: " + username);
                return true;
            } else {
                System.out.println("password didn't match");
            }
        }
        return false;
    }
}
