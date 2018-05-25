/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IMedicine;
import java.sql.ResultSet;

/**
 *
 * @author Bruger
 */
public class Medicine implements IMedicine {
    private int medicineID;
    private String dosage;
    private String name;
    private String VNR;
    
    public Medicine(String name, String VNR, String dosage, int medicineID) {
        this.dosage = dosage;
        this.VNR = VNR;
        this.name = name;
        this.medicineID = medicineID;
    }
    
    public Medicine(String name, String VNR, String dosage) {
        this.name = name;
        this.VNR = VNR;
        this.dosage = dosage;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setVNR(String VNR) {
        this.VNR = VNR;
    }

    public String getName() {
        return name;
    }

    public String getVNR() {
        return VNR;
    }
    
    public int getMedicineID(){
        return medicineID;
    }


    @Override
    public String getDosage() {
        return dosage;
    }

    @Override
    public String toString() {
        String s ="Navn: " + name + ", VNR: " + VNR + ", Dosis: " + dosage;
        return s;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    
    public void pushMedicine(int caseID, int currentUserID) {
        Business.getInstance().getData().saveMedicine(this, caseID);
        Business.getInstance().getData().saveToCaseLog(currentUserID,
                caseID,
                Business.getInstance().getCalendar().getTodaysDateString(),
                Business.getInstance().getCalendar().getTodaysTimeString());
    }
    
    public void deleteMedicine(int caseID, int currentUserID){
        Business.getInstance().getData().deleteMedicine(this);
        Business.getInstance().getData().saveToCaseLog(currentUserID, 
                caseID, 
                Business.getInstance().getCalendar().getTodaysDateString(), 
                Business.getInstance().getCalendar().getTodaysTimeString());
    }
}
