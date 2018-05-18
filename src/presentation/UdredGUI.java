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
    
    private static UdredGUI ui;
    private IBusiness business;

    public UdredGUI(Stage stage, IBusiness business) {
        this.business = business;
        ui = this;
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
    
    public static UdredGUI getInstance(){
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
