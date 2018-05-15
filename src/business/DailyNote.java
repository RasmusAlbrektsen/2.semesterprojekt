/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IDaylyNote;
import java.util.Date;

/**
 *
 * @author rasmusstamm
 */
class DailyNote implements IDaylyNote{

    private Date date;
    private String note;
    private User user;

    public DailyNote(String note, User user) {
        this.note = note;
        this.user = user;
        date = new Date();
    }

}
