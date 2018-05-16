package business;

import Acq.ICitizen;

/**
 *
 * @author Bruger
 */
public class Citizen implements ICitizen{

    private String CPR;
    private boolean nemIDAccept;

    public Citizen(String CPR) {
        this.CPR = CPR;
    }
    
    public boolean login(String un, String pw){
        return true;
    }
}