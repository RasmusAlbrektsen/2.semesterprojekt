package business;

import Acq.IAppointment;
import Acq.ICalendar;
import Acq.IUser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Calendar implements ICalendar{
    private User user;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
    
    public Calendar() {
        
    }
    
    /**
     * Gets the string of the appointments of a specific user on a specific date
     * @param date
     * @param user
     * @return String
     */
    @Override
    public String getDailyAppointments(String date, IUser user) {
        String s = "";
        
        for(IAppointment ap : user.getAppointments()) {
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
    
    /**
     * Gets the days time string
     * @return String
     */
    @Override
    public String getTodaysTimeString() {
        Date todaysDate = new Date();
        String s = sdf3.format(todaysDate);
        return s;
    }
    
    /**
     * Gets the days date string
     * @return String
     */
    @Override
    public String getTodaysDateString() {
        Date todaysDate = new Date();
        String s = sdf2.format(todaysDate);
        return s;
    }
    
    /**
     * Gets the days date string in the danish format
     * @return String
     */
    @Override
    public String getTodaysDateStringDK() {
        Date todaysDate = new Date();
        String s = sdf.format(todaysDate);
        return s;
    }
    
    /**
     * gets todays date
     * @return Date
     */
    @Override
    public Date getTodaysDate() {
        Date todaysDate = new Date();
        return todaysDate;
    }
    
    /**
     * Formats the localDate
     * @param date
     * @return String
     */
    @Override
    public String formatLocalDate(LocalDate date) {
        String s = date.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"));
        return s;
    }
    
    /**
     * Formats a date in a string, so it can be used on the database
     * @param date
     * @return String
     */
    @Override
    public String formatToDataString(String date) {
        String[] dateSplitter = date.split("-");
        String dataString = dateSplitter[2] + "-" + dateSplitter[1] + "-" + dateSplitter[0];
        return dataString;
    }
    
    /**
     * Formats a date in a string to the presentation layer.
     * @param date
     * @return String
     */
    @Override
    public String formatToPresentationString(String date) {
        String[] dateSplitter = date.split("-");
        String dataString = dateSplitter[2] + "-" + dateSplitter[1] + "-" + dateSplitter[0];
        return dataString;
    }
    
    /**
     * Parses a localDate to correct Date order.
     * @param date
     * @return Date
     */
    @Override
    public Date parseDate(LocalDate date) {
        try {
            Date d = sdf.parse(date.format(DateTimeFormatter.ofPattern("dd-MM-uuuu")));
            return d;
        } catch (Exception e) {
        }
        return null;
    }
    
    /**
     * Formats a date to string
     * @param date
     * @return String
     */
    @Override
    public String formatToString(Date date) {
        String s = sdf2.format(date);
        return s;
    }
}
