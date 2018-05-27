package presentation;

import Acq.IBusiness;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UdredGUI {

    private static UdredGUI ui = null;
    private IBusiness business;

    private UdredGUI() {
        ui = this;
    }

    /**
     * Setter for the business.
     * @param business 
     */
    public void setBusiness(IBusiness business) {
        this.business = business;
    }

    /**
     * Getter that creates a new instance if it doesn't exist.
     * @return 
     */
    public static UdredGUI getInstance() {
        if (ui == null) {
            ui = new UdredGUI();
        }
        return ui;
    }

    /**
     * Getter for the attribute business.
     * @return IBusiness
     */
    public IBusiness getBusiness() {
        return business;
    }

    /**
     * Loads a controller with the name parameter.
     * @param stage
     * @param name
     * @return 
     */
    public FXMLLoader loadController(Stage stage, String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(name + ".fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            stage.setMinHeight(800);
            stage.setMinWidth(1280);
            stage.setScene(scene);
            stage.show();
            return loader;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
