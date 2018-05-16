/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.ICase;
import Acq.IDailyNote;
import business.Medicine;
import business.Offer;
import business.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rasmusstamm
 */
public class DataCase implements ICase{
    private int caseNumber;
    private int IDNum;
    private Date creationDate;
    private String CPR;
    private boolean isActive;
    //private List<Appointment> appointments;
    private List<Medicine> medicineList;
    private Offer offer;
    private User caseWorker;
    private List<IDailyNote> dailyNotes;

    public DataCase(int caseNumber, Date creationDate, List<IDailyNote> dailyNotes) {
        this.caseNumber = caseNumber;
        this.creationDate = creationDate;
        this.dailyNotes = dailyNotes;
    }
    
}
