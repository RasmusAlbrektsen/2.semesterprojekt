package presentation;

import Acq.IBusiness;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Bruger
 */
public class UdredGUI {
    
    private static UdredGUI ui = null;
    private IBusiness business;
    

    private UdredGUI() {
        ui = this;
    }
    public void setBusiness(IBusiness business){
        this.business = business;
    }
    public static UdredGUI getInstance(){
        if (ui == null){
            ui = new UdredGUI();
        }
        return ui;
    }
    
    
    public IBusiness getBusiness(){
        return business;
    }
    
    public void loadController(Stage stage, String name){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(name+".fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
