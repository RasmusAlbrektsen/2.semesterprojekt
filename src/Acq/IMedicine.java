package Acq;

/**
 *
 * @author rasmusstamm
 */
public interface IMedicine {
    public String getName();
    public String getAmount();
    public String getDosage();
    public String toString();
    public void setAmount(String amount);
    public void setDosage(String dosage);
}
