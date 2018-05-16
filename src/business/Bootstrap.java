/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import Acq.IBusiness;
import Acq.IData;
import Acq.IGUI;
import data.DataFacade;
import javafx.application.Application;
import javafx.stage.Stage;
import presentation.GUIFacade;

/**
 *
 * @author Bruger
 */
public class Bootstrap extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        IGUI gui = new GUIFacade();
        IBusiness business = new BusinessFacade();
        IData data = new DataFacade();
        gui.injectBusiness(business);
        business.injectData(data);
        gui.start(primaryStage);
        
        
    }

}
