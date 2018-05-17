package business;

import Acq.ICase;
import Acq.IDailyNote;

import Acq.IMedicine;
import Acq.IOffer;
import Acq.IUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Case implements ICase{

    private int caseNumber;
    private int IDNum;
    private Date creationDate;
    private String CPR;
    private boolean isActive;
    
    private List<IMedicine> medicineList;
    private IOffer offer;

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
    public boolean createDailyNote(String note) {
        dailyNotes.add(new DailyNote(note));
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
    public boolean isActive() {
        return isActive;
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
    public IUser getCaseWorker() {
        return caseWorker;
    }


    @Override
    public List<IDailyNote> getDailyNotes() {
        return dailyNotes;
    }
}
