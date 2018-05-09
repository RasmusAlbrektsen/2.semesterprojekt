/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruger
 */
public class Calendar {
    private User user;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    public Calendar() {
        
    }
    
    public String getDailyAppointments(String date) {
        String s = "";
        
        for(Appointment ap : user.getAppointments()) {
            try {
                if(ap.getDate().equals(sdf.parse(getTodaysDate()))) {
                    s += ap.getNote() + "\n";
                }
            } catch (ParseException ex) {
                System.out.println("Format doesn't match.");
            }
        }
        System.out.println(s);
        return s;
    }
    
    public String getTodaysDate() {
        Date todaysDate = new Date();
        String s = sdf.format(todaysDate);
        return s;
    }
    
}
