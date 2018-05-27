package Acq;

public interface IMedicine {

    String getName();

    String getDosage();

    String toString();

    void setDosage(String dosage);

    String getVNR();
    
    int getMedicineID();
    
    void deleteMedicine(int caseID, int currentUser);
}
