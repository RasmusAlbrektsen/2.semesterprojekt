package business;

import Acq.ICase;
import Acq.IDailyNote;
import Acq.IMedicine;
import Acq.IOffer;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * Constructor for when making a new case, that doesn't exist on the database.
     * @param CPR
     * @param info 
     */
    public Case(String CPR, String info) {
        this.CPR = CPR;
        this.info = info;
        creationDate = Business.getInstance().getCalendar().formatToString(new Date());
        dailyNotes = new ArrayList<>();
        medicineList = new ArrayList<>();
    }
    /**
     * Constructor for when loading the case from the datebase.
     * @param IDNum
     * @param caseDirectory
     * @param creationDate
     * @param CPR
     * @param isActive 
     */
    public Case(int IDNum, String caseDirectory, String creationDate, String CPR, boolean isActive) {
        this.CPR = CPR;
        this.IDNum = IDNum;
        this.caseDirectory = caseDirectory;
        this.info = Business.getInstance().getData().getCaseInfo(caseDirectory);
        this.creationDate = creationDate;
        this.isActive = isActive;
        dailyNotes = new ArrayList<>();
        medicineList = new ArrayList<>();
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

    /**
     * Creates a new medicine and adds it to the medicineList
     * @param name
     * @param VNR
     * @param dosage
     * @return boolean
     */
    @Override
    public boolean createMedicine(String name, String VNR, String dosage) {
        medicineList.add(new Medicine(name, VNR, dosage, IDNum));
        Business.getInstance().getData().saveMedicine(new Medicine(name, VNR, dosage), IDNum);
        System.out.println(name+VNR+dosage);
        return true;
    }

    /**
     * Updates the medicine in the parameter, with the other parameters
     * @param medicine
     * @param amount
     * @param dose
     * @return boolean
     */
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
    
    /**
     * Not implemented!
     * @param currentUser
     * @param medicineIndex
     * @return 
     */
    @Override
    public boolean removeMedicine(int currentUser, int medicineIndex){
        
        return true;
    }

    /**
     * Not implemented!
     * @param residence
     * @param startDate
     * @return 
     */
    @Override
    public boolean createOffer(String residence, Date startDate) {
        return true;
    }

    /**
     * Not implemented!
     * @param residence
     * @param startDate
     * @param endDate
     * @return 
     */
    @Override
    public boolean createOffer(String residence, Date startDate, Date endDate) {
        return true;
    }

    /**
     * Adds a dailyNote to the cases dailyNotes list by calling the dailyNote constructor.
     * @param note
     * @return boolean
     */
    @Override
    public boolean createDailyNote(String note) {
        dailyNotes.add(new DailyNote(note));
        return true;
    }

    /**
     * Getter for the attribute IDNumber.
     * @return integer 
     */
    @Override
    public int getCaseNumber() {
        return IDNum;
    }

    /**
     * Getter for the attribute creationDate
     * @return String
     */
    @Override
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Getter for the attribute CPR
     * @return String
     */
    @Override
    public String getCPR() {
        return CPR;
    }
    
    /**
     * Getter for the attribute info
     * @return String
     */
    @Override
    public String getInfo(){
        return info;
    }

    /**
     * Getter for the attribute isActive
     * @return boolean
     */
    @Override
    public boolean isActive() {
        return isActive;
    }

    /**
     * Getter for the list medicineList
     * @return List
     */
    @Override
    public List<IMedicine> getMedicine() {
        return medicineList;
    }

    /**
     * Getter for the attribute offer
     * @return IOffer
     */
    @Override
    public IOffer getOffer() {
        return offer;
    }

    /**
     * Getter for the list dailyNotes
     * @return List
     */
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
    
    /**
     * Saves the case, the ID parameter, will be added to the CaseLog table on the datebase
     * @param currentUserID 
     */
    @Override
    public void saveCase(int currentUserID) {
        IDNum = Business.getInstance().getData().saveCase(this, info);
        Business.getInstance().getData().saveCreatedCaseLog(currentUserID, 
                IDNum, 
                Business.getInstance().getCalendar().getTodaysDateString(), 
                Business.getInstance().getCalendar().getTodaysTimeString());
        
    }
    
    /**
     * Deletes a case from the database, the ID parameter will be added to the CaseLog table on the database
     * @param currentUserID 
     */
    @Override
    public void deleteCase(int currentUserID) {
        Business.getInstance().getData().deleteCase(this);
        Business.getInstance().getData().saveToCaseLog(currentUserID,
                IDNum,
                Business.getInstance().getCalendar().getTodaysDateString(),
                Business.getInstance().getCalendar().getTodaysTimeString());
    }
}
