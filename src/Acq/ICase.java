package Acq;

import java.util.Date;
import java.util.List;


public interface ICase {
    
    boolean isActive();



    int getCaseNumber();
    Date getCreationDate();
    String getCPR();
    List<IMedicine> getMedicine();
    IOffer getOffer();
    IUser getCaseWorker();
    List<IDailyNote> getDailyNotes();
            }

