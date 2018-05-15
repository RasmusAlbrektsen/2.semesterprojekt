/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import java.util.Date;
import java.util.List;

/**
 *
 * @author rasmusstamm
 */
public interface ICase {
    public boolean createMedicine(String name, String amount, String dose);
    public boolean updateMedicine(IMedicine medicine, String amount, String dose);
    public boolean createOffer(String residence, Date startDate);
    public boolean createOffer(String residence, Date startDate, Date endDate);
    public boolean createDailyNote();
    public void setCreationDate(Date creationDate);
    public int getCaseNumber();
    public Date getCreationDate();
    public String getCPR();
    public boolean isIsActive();
//    public List<Appointment> getAppointments();
    public List<IMedicine> getMedicine();
    public IOffer getOffer();
    public IUser getCaseWorker();
    public List<IDailyNote> getDailyNotes();
            }