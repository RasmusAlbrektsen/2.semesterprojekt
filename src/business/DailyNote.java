/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IDailyNote;
import Acq.IUser;
import java.util.Date;


class DailyNote implements IDailyNote{

    private Date date;
    private String note;

    public DailyNote(String note) {
        this.note = note;
        date = new Date();
    }

}
