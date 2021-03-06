package Acq;

import java.util.Date;
import java.util.List;

public interface ICase {

    boolean isActive();

    int getCaseNumber();

    String getCreationDate();

    String getCPR();

    List<IMedicine> getMedicine();

    IOffer getOffer();

    List<IDailyNote> getDailyNotes();
    
    String getInfo();
    
    boolean createMedicine(String name, String VNR, String dose);
    
    boolean updateMedicine(IMedicine medicine, String amount, String dose);
    
    boolean removeMedicine(int currentUser, int medicineIndex);

    boolean createOffer(String residence, Date startDate);
    
    boolean createOffer(String residence, Date startDate, Date endDate);
    
    boolean createDailyNote(String note);
    
    void updateCase(int currentUserID, String info);
    
    void saveCase(int currentUserID);
    
    void deleteCase(int currentUserID);
}
