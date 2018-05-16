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
public class UdredGUI extends Application {
    
    private IBusiness business;

    public UdredGUI(Stage stage, IBusiness business) {
    this.business = business;
    
        try {
            start(stage);   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
}
