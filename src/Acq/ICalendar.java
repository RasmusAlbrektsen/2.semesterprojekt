/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public String formatToString(Date date);
    
}
