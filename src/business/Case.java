/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.ICase;
import Acq.IDailyNote;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bruger
 */
public class Case implements ICase{

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

    public Case(String CPR, int IDNum) {
        this.CPR = CPR;
        this.IDNum = IDNum;
        creationDate = new Date();
        dailyNotes = new ArrayList<>();
        //appointments = new ArrayList<>();
        medicineList = new ArrayList<>();
    }

    public boolean createMedicine(String name, String amount, String dose) {
        medicineList.add(new Medicine(name, amount, dose));
        return true;
    }

    public boolean updateMedicine(Medicine medicine, String amount, String dose) {
        for (Medicine med : medicineList) {
            if(med == medicine) {
                med.setAmount(amount);
                med.setDosage(dose);
                
                return true;
            }
        }
        return false;
    }

    public boolean createOffer(String residence, Date startDate) {
        return true;
    }

    public boolean createOffer(String residence, Date startDate, Date endDate) {
        return true;
    }
    
    public boolean createDailyNote(String note) {
        dailyNotes.add(new DailyNote(note));
        return true;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getCPR() {
        return CPR;
    }

    public boolean isIsActive() {
        return isActive;
    }

    /*public List<Appointment> getAppointments() {
        return appointments;
    }*/

    public List<Medicine> getMedicine() {
        return medicineList;
    }

    public Offer getOffer() {
        return offer;
    }

    public User getCaseWorker() {
        return caseWorker;
    }

    public List<IDailyNote> getDailyNotes() {
        return dailyNotes;
    }
    
    
}
