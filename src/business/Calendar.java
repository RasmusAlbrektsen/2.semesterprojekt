package business;

import Acq.ICalendar;
import Acq.IUser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Bruger
 */
public class Calendar implements ICalendar{
    private User user;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    public Calendar() {
        
    }
    
    public String getDailyAppointments(String date, IUser user) {
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
