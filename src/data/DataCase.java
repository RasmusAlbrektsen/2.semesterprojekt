/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.ICase;
import Acq.IDailyNote;
import Acq.IMedicine;
import Acq.IOffer;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rasmusstamm
 */
public class DataCase implements ICase {

    private int caseNumber;
    private int IDNum;
    private Date creationDate;
    private String CPR;
    private boolean isActive;
    private List<IMedicine> medicineList;
    private IOffer offer;
    private List<IDailyNote> dailyNotes;

    public DataCase(int caseNumber, Date creationDate, List<IDailyNote> dailyNotes) {
        this.caseNumber = caseNumber;
        this.creationDate = creationDate;
        this.dailyNotes = dailyNotes;
    }

    @Override
    public int getCaseNumber() {
        return caseNumber;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public String getCPR() {
        return CPR;
    }

    @Override
    public List<IMedicine> getMedicine() {
        return medicineList;
    }

    @Override
    public IOffer getOffer() {
        return offer;
    }

    @Override
    public List<IDailyNote> getDailyNotes() {
        return dailyNotes;
    }

    @Override
    public boolean createMedicine(String name, String dose, String CPR) {
        medicineList.add(new DataMedicine(name, dose, CPR));
        return true;
    }

    @Override
    public boolean updateMedicine(IMedicine medicine, String amount, String dose) {
        for (IMedicine med : medicineList) {
            if (med == medicine) {
                med.setDosage(dose);

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean createOffer(String residence, Date startDate) {
        return true;
    }

    @Override
    public boolean createOffer(String residence, Date startDate, Date endDate) {
        return true;
    }

    @Override
    public boolean createDailyNote(String note) {
        dailyNotes.add(new DataDailyNote(note));
        return true;
    }
    
    @Override
    public String toString(){
        return "Sagsnummer: "+ this.caseNumber +", oprettelsesdato: " + this.creationDate.toString() + " sag: "+activityString();
    }
    
    private String activityString(){
        if (isActive) {
            return "åben";
        }
        return "lukket";
    }


}
