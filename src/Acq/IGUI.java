package Acq;

import javafx.stage.Stage;


/**
 * Interface for GUI
 */
public interface IGUI {

    public void injectBusiness(IBusiness business);
    void start(Stage stage) throws Exception;
}