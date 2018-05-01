/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.IMedicine;

/**
 *
 * @author rasmusstamm
 */
public class DataMedicine implements IMedicine {

    private String name;
    private String amount;
    private String dosage;

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
}
