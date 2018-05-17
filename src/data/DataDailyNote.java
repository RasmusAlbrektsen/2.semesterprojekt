
package data;


import Acq.IDailyNote;
import java.util.Date;


public class DataDailyNote implements IDailyNote{
    private Date date;
    private String note;

    public DataDailyNote(Date date, String note) {
        this.date = date;
        this.note = note;
    }

    
}
