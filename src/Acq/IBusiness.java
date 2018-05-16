package Acq;

/**
 *
 * @author Bruger
 */
public interface IBusiness {
    
    public void injectData(IData data);
    boolean login(String username, String password);
}
