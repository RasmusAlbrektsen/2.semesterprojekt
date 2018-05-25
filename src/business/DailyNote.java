/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IDailyNote;
import Acq.IUser;
import java.util.Date;


class DailyNote implements IDailyNote{

    private String date;
    private String note;
    private int noteID;

    public DailyNote(String note) {
        this.note = note;
        date = Business.getInstance().getCalendar().formatToString(new Date());
    }
    
    public DailyNote (int noteID, String note, String date){
        this.date = date;
        this.note = note;
        this.noteID = noteID;
    }
    
    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }
    
    public void pushDailyNote(int caseID, int currentUserID) {
        Business.getInstance().getData().saveDailyNote(this, caseID);
        Business.getInstance().getData().saveToCaseLog(currentUserID,
                caseID,
                Business.getInstance().getCalendar().getTodaysDateString(),
                Business.getInstance().getCalendar().getTodaysTimeString());
    }
}
