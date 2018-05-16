/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.IDailyNote;
import business.User;
import java.util.Date;

/**
 *
 * @author rasmusstamm
 */
public class DataDailyNote implements IDailyNote{
    private Date date;
    private String note;

    public DataDailyNote(Date date, String note) {
        this.date = date;
        this.note = note;
    }
    
}
