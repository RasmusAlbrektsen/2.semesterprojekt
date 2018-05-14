/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Bruger
 */
public class Calendar {
    private User user;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    public Calendar() {
        
    }
    
    public String getDailyAppointments(String date, User user) {
        String s = "";
        
        for(Appointment ap : user.getAppointments()) {
            try {
                if(ap.getDate().equals(sdf.parse(getTodaysDateString()))) {
                    s += ap.getNote() + "\n";
                }
            } catch (ParseException ex) {
                System.out.println("Format doesn't match.");
            }
        }
        System.out.println(s);
        return s;
    }
    
    public String getTodaysDateString() {
        Date todaysDate = new Date();
        String s = sdf.format(todaysDate);
        return s;
    }
    
    public Date getTodaysDate() {
        Date todaysDate = new Date();
        return todaysDate;
    }
    
    public String formatLocalDate(LocalDate date) {
        String s = date.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"));
        return s;
    }
    
    public String formatToString(Date date) {
        String s = sdf.format(date);
        return s;
    }
}
