/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Acq.IBusiness;
import Acq.IGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Gui facade which implements the inferface for GUI
 */
public class GUIFacade implements IGUI {

    /**
     * Instance of IGame
     */
    private IBusiness business;

    public IBusiness getBusiness(){
        return business;
    }
    
    /**
     * A method to inject game
     *
     * @param game
     */
    @Override
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }

    @Override
    public void start(Stage stage) throws Exception {
        UdredGUI.getInstance().setBusiness(business);
//        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
    }
}