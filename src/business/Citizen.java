package business;

import Acq.ICitizen;

public class Citizen implements ICitizen{

    private String CPR;
    private boolean nemIDAccept;

    public Citizen(String CPR) {
        this.CPR = CPR;
    }
    
    /**
     * Not implemented!
     * @param un
     * @param pw
     * @return 
     */
    @Override
    public boolean login(String un, String pw){
        return true;
    }
}