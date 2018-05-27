package business;

import Acq.IMedicine;

public class Medicine implements IMedicine {
    private int medicineID;
    private String dosage;
    private String name;
    private String VNR;
    
    /**
     * Constructor for when loading from the database
     * @param name
     * @param VNR
     * @param dosage
     * @param medicineID 
     */
    public Medicine(String name, String VNR, String dosage, int medicineID) {
        this.dosage = dosage;
        this.VNR = VNR;
        this.name = name;
        this.medicineID = medicineID;
    }
    
    /**
     * Construct for when making a new Medicine object
     * @param name
     * @param VNR
     * @param dosage 
     */
    public Medicine(String name, String VNR, String dosage) {
        this.name = name;
        this.VNR = VNR;
        this.dosage = dosage;
    }
    
    /**
     * Setter for the attrbute name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the attribute VNR
     * @param VNR 
     */
    public void setVNR(String VNR) {
        this.VNR = VNR;
    }

    /**
     * Getter for the attribute name
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter for the attribute VNR
     * @return 
     */
    @Override
    public String getVNR() {
        return VNR;
    }
    
    /**
     * Getter for the attribute  medicineID
     * @return integer
     */
    @Override
    public int getMedicineID(){
        return medicineID;
    }

    /**
     * Getter for the attribute  dosage
     * @return String
     */
    @Override
    public String getDosage() {
        return dosage;
    }

    /**
     * Creates a string that contains information of the specific object
     * @return String
     */
    @Override
    public String toString() {
        String s ="Navn: " + name + ", VNR: " + VNR + ", Dosis: " + dosage;
        return s;
    }

    /**
     * Setter for the attribute dosage
     * @param dosage 
     */
    @Override
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    
    /**
     * Pushes the medicine to the database
     * @param caseID
     * @param currentUserID 
     */
    public void pushMedicine(int caseID, int currentUserID) {
        Business.getInstance().getData().saveMedicine(this, caseID);
        Business.getInstance().getData().saveToCaseLog(currentUserID, caseID, Business.getInstance().getCalendar().getTodaysDateString(), Business.getInstance().getCalendar().getTodaysTimeString());
    }
    
    /**
     * Deletes the medicine from the case with the specific ID.
     * @param caseID
     * @param currentUserID 
     */
    @Override
    public void deleteMedicine(int caseID, int currentUserID){
        Business.getInstance().getData().deleteMedicine(this);
        Business.getInstance().getData().saveToCaseLog(currentUserID, caseID, Business.getInstance().getCalendar().getTodaysDateString(), Business.getInstance().getCalendar().getTodaysTimeString());
    }
}
