/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Bruger
 */
public class Citizen {

    private String CPR;
    private boolean nemIDAccept;

    public Citizen(String CPR) {
        this.CPR = CPR;
    }
    
    private boolean login(String un, String pw){
        return true;
    }

}
