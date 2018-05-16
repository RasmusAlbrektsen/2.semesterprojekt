/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IMedicine;

/**
 *
 * @author Bruger
 */
public class Medicine implements IMedicine {

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

    public Medicine(String name, String amount, String dosage) {
        this.dosage = dosage;
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
}
