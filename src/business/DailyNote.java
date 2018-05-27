package business;

import Acq.IDailyNote;
import java.util.Date;

class DailyNote implements IDailyNote{

    private String date;
    private String note;
    private int noteID;

    /**
     * Constructor for when making a new DailyNote
     * @param note 
     */
    public DailyNote(String note) {
        this.note = note;
        date = Business.getInstance().getCalendar().formatToString(new Date());
    }
    
    /**
     * Constructor for when loading a DailyNote from the database.
     * @param noteID
     * @param note
     * @param date 
     */
    public DailyNote (int noteID, String note, String date){
        this.date = date;
        this.note = note;
        this.noteID = noteID;
    }
    
    /**
     * Getter for the attribute date
     * @return String
     */
    @Override
    public String getDate() {
        return date;
    }

    /**
     * Getter for the attribute note
     * @return String
     */
    @Override
    public String getNote() {
        return note;
    }

    /**
     * Getter for the attribute noteID
     * @return 
     */
    @Override
    public int getNoteID() {
        return noteID;
    }

    /**
     * Setter for the attribute date
     * @param date 
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Setter for the attribute note
     * @param note 
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Setter for the attribute noteID
     * @param noteID 
     */
    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }
    
    /**
     * Pushes the dailyNote so it's saved on the database
     * @param caseID
     * @param currentUserID 
     */
    public void pushDailyNote(int caseID, int currentUserID) {
        Business.getInstance().getData().saveDailyNote(this, caseID);
        Business.getInstance().getData().saveToCaseLog(currentUserID,
                caseID,
                Business.getInstance().getCalendar().getTodaysDateString(),
                Business.getInstance().getCalendar().getTodaysTimeString());
    }
}
