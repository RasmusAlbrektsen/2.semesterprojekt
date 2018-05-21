package Acq;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Kasper
 */
public interface ICalendar {
    
    public String getDailyAppointments(String date, IUser user);
    public String getTodaysDateString();
    public Date getTodaysDate();
    public String formatLocalDate(LocalDate date);
    public Date parseDate(LocalDate date);
    public String formatToString(Date date);
    public String formatToDataString(String date);
    public String formatToPresentationString(String date);
    
}
