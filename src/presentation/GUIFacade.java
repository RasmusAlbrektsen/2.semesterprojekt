/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Acq.IBusiness;
import Acq.IGUI;
import javafx.stage.Stage;

/**
 * Gui facade which implements the inferface for GUI
 */
public class GUIFacade implements IGUI {

    /**
     * Instance of IGame
     */
    private IBusiness business;

    /**
     * A method to inject game
     *
     * @param game
     */
    @Override
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }

    
}