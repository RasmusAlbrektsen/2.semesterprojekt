/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.IAppointment;

/**
 *
 * @author rasmusstamm
 */
class DataAppointment implements IAppointment {

    private int IDNum;

    @Override
    public int getIDNum() {
        return IDNum;
    }

}
