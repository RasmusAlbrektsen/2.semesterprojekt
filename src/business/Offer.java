/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IOffer;

/**
 *
 * @author Bruger
 */
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
