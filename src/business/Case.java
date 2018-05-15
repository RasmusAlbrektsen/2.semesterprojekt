/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.ICase;
import Acq.IDailyNote;
import Acq.IMedicine;
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
    private List<IMedicine> medicineList;
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

    @Override
    public boolean createMedicine(String name, String amount, String dose) {
        medicineList.add(new Medicine(name, amount, dose));
        return true;
    }

    @Override
    public boolean updateMedicine(IMedicine medicine, String amount, String dose) {
        for (IMedicine med : medicineList) {
            if(med == medicine) {
                med.setAmount(amount);
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
    public boolean createDailyNote() {
        dailyNotes.add(new DailyNote(CPR, caseWorker));
        return true;
    }

    @Override
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
    public String getCPR() {
        return CPR;
    }

    @Override
    public boolean isIsActive() {
        return isActive;
    }

    /*public List<Appointment> getAppointments() {
        return appointments;
    }*/

    @Override
    public List<IMedicine> getMedicine() {
        return medicineList;
    }

    @Override
    public Offer getOffer() {
        return offer;
    }

    @Override
    public User getCaseWorker() {
        return caseWorker;
    }

    @Override
    public List<IDailyNote> getDailyNotes() {
        return dailyNotes;
    }
    
    
}
