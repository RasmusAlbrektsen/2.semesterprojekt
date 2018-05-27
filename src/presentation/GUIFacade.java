package presentation;

import Acq.IBusiness;
import Acq.IGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIFacade implements IGUI {

    /**
     * Instance of IGame
     */
    private IBusiness business;

    public IBusiness getBusiness(){
        return business;
    }

    /**
     * Injects the business object into the business object.
     * @param business 
     */
    @Override
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }

    @Override
    public void start(Stage stage) throws Exception {
        UdredGUI.getInstance().setBusiness(business);
        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
}