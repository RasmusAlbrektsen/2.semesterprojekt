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

    private String name;
    private String amount;
    private String dosage;

    public Medicine(String name, String amount, String dosage) {
        this.name = name;
        this.amount = amount;
        this.dosage = dosage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAmount() {
        return amount;
    }

    @Override
    public String getDosage() {
        return dosage;
    }

    @Override
    public String toString() {
        String s = "Name: " + name + " amount: " + amount + " dosage: " + dosage;
        return s;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
