/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import java.util.Date;

/**
 *
 * @author rasmusstamm
 */
public interface ICase {

    int getCaseNumber();

    Date getCreationDate();
    
    boolean isActive();

}
