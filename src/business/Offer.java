package business;

import Acq.IOffer;

public class Offer implements IOffer{
    private String residence;
    private String startDate;
    private String endDate;

    public Offer(String residence, String startDate) {
        this.residence = residence;
        this.startDate = startDate;
    }

    public Offer(String residence, String startDate, String endDate) {
        this.residence = residence;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    
}
