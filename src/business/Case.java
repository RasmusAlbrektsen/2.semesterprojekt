package business;

import Acq.ICalendar;
import Acq.ICase;
import Acq.IDailyNote;
import Acq.IMedicine;
import Acq.IOffer;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sun.security.tools.KeyStoreUtil;

public class Case implements ICase {

    private int IDNum;
    private String creationDate;
    private boolean isActive;
    private String caseDirectory;
    private String info;
    private List<IMedicine> medicineList;
    private IOffer offer;
    private List<IDailyNote> dailyNotes;
    private String CPR;

    public Case(String CPR, String info) {
        this.CPR = CPR;
        this.info = info;
        creationDate = Business.getInstance().getCalendar().formatToString(new Date());
        dailyNotes = new ArrayList<>();
        medicineList = new ArrayList<>();
    }

    public Case(int IDNum, String caseDirectory, String creationDate, String CPR, boolean isActive) {
        this.CPR = CPR;
        this.IDNum = IDNum;
        this.caseDirectory = caseDirectory;
        this.info = Business.getInstance().getData().getCaseInfo(caseDirectory);
        this.creationDate = creationDate;
        this.isActive = isActive;
        dailyNotes = new ArrayList<>();
        ResultSet rs = Business.getInstance().getData().getDailyNote(IDNum);
        try {
            while (rs.next()) {
                dailyNotes.add(new DailyNote(rs.getInt("noteid"),
                        rs.getString("note"),
                        rs.getString("date")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultSet rs2 = Business.getInstance().getData().getMedicine(IDNum);
        try {
            while (rs2.next()) {
                medicineList.add(new Medicine(rs2.getString("name"),
                        rs2.getString("vnr"),
                        rs2.getString("dosage"),
                        rs2.getInt("medicineID")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean createMedicine(String name, String VNR, String dosage) {
        medicineList.add(new Medicine(name, VNR, dosage, IDNum));
        Business.getInstance().getData().saveMedicine(new Medicine(name, VNR, dosage), IDNum);
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
        dailyNotes.add(new DailyNote(note));
        return true;
    }

    @Override
    public int getCaseNumber() {
        return IDNum;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String getCPR() {
        return CPR;
    }
    
    @Override
    public String getInfo(){
        return info;
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
    public List<IDailyNote> getDailyNotes() {
        return dailyNotes;
    }
    @Override
    public void updateCase(int currentUserID, String info) {
        this.info = info;
        Business.getInstance().getData().updateCase(this);
        Business.getInstance().getData().saveCreatedCaseLog(currentUserID, 
                IDNum, 
                Business.getInstance().getCalendar().getTodaysDateString(), 
                Business.getInstance().getCalendar().getTodaysTimeString());
    }
    
    @Override
    public void saveCase(int currentUserID) {
        IDNum = Business.getInstance().getData().saveCase(this, info);
        Business.getInstance().getData().saveCreatedCaseLog(currentUserID, 
                IDNum, 
                Business.getInstance().getCalendar().getTodaysDateString(), 
                Business.getInstance().getCalendar().getTodaysTimeString());
        
    }
    
    @Override
    public void deleteCase(int currentUserID) {
        Business.getInstance().getData().deleteCase(this);
        Business.getInstance().getData().saveToCaseLog(currentUserID,
                IDNum,
                Business.getInstance().getCalendar().getTodaysDateString(),
                Business.getInstance().getCalendar().getTodaysTimeString());
    }
}
