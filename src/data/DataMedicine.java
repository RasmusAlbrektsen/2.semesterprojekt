/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.IMedicine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rasmusstamm
 */
public class DataMedicine implements IMedicine {
    String url = "jdbc:postgresql://horton.elephantsql.com:5432/zibscemz";
    String username = "zibscemz";
    String passwd = "7A1e6LvgBXjitm0pjGI3tIOf5aCpr0Qe";
    private String dosage;
    private String VNR;
    private String name;

    public DataMedicine(String name, String dosage, String VNR) {
        this.dosage = dosage;
        this.VNR = VNR;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getVNR() {
        return VNR;
    }
    @Override
    public String getDosage() {
        return dosage;
    }
    @Override
    public String toString() {
        String s = "Name: " + name + " dosage: " + dosage + " VNR: " + VNR;
        return s;
    }
}
