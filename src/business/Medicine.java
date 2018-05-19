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

    public Medicine(String name, String VNR, String dosage, int caseID) {
        this.dosage = dosage;
        this.VNR = VNR;
        this.name = name;
        Business.getInstance().getData().saveMedicine(this, caseID);
        this.medicineID = Business.getInstance().getData().getMedicineID(caseID, VNR);
        
        
    }
    
    public Medicine(int caseID) {
        ResultSet rs = Business.getInstance().getData().getMedicine(caseID); 
        try {
        this.VNR = rs.getString("VNR");
        this.dosage = rs.getString("dosage");
        this.name = rs.getString("name");
        this.medicineID = rs.getInt("medicineID");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public String getDosage() {
        return dosage;
    }

    @Override
    public String toString() {
        String s ="Dosage: " + dosage;
        return s;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    
    public void pushMedicine(int caseID) {
        Business.getInstance().getData().saveMedicine(this, caseID);
    }
}
