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
    
    boolean createMedicine(String name, String amount, String dose);
    
    boolean updateMedicine(IMedicine medicine, String amount, String dose);

    boolean createOffer(String residence, Date startDate);
    
    boolean createOffer(String residence, Date startDate, Date endDate);
    
    boolean createDailyNote(String note);
    
    void updateCase();
    
    void saveCase(int currentUserID);
}
