package Acq;

/**
 *
 * @author rasmusstamm
 */
public interface IMedicine {
    String getName();
    String getAmount();
    String getDosage();
    String toString();
    void setAmount(String amount);
    void setDosage(String dosage);
    String getVNR();
}
