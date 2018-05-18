/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Acq.IBusiness;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class AdministratorWindowController implements Initializable {

    @FXML
    private ListView<?> userListView;
    @FXML
    private ListView<?> logListView;
    @FXML
    private Button showUsersButton;
    @FXML
    private Button addUserButton;
    @FXML
    private Button removeUserButton;
    @FXML
    private Button showLogButton;
    @FXML
    private Button updateUserButton;
    
    private IBusiness business = UdredGUI.getInstance().getBusiness();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showUsersAction(ActionEvent event) {
    }

    @FXML
    private void addUserAction(ActionEvent event) {
    }

    @FXML
    private void removeUserAction(ActionEvent event) {
    }

    @FXML
    private void updateUserAction(ActionEvent event) {
    }

    @FXML
    private void showLogAction(ActionEvent event) {
    }
    
}
