/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Bruger
 */
public class Case {

    private int caseNumber;
    private Date creationDate;
    private String CPR;
    private boolean isActive;
    private List<Appointment> appointments;
    private List<Medicine> medicine;
    private Offer offer;
    private User caseWorker;
    private List<DailyNote>dailyNotes;

    public Case(String CPR) {
        this.CPR = CPR;
    }

}
