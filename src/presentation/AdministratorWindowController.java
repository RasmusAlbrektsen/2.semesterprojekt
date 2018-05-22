/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Acq.IBusiness;
import Acq.ICase;
import Acq.IUser;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ListView<String> userListView;
    @FXML
    private ListView<String> logListView;
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
    private ObservableList<String> userList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showUsersButton.fire();
    }    

    @FXML
    private void showUsersAction(ActionEvent event) {
        userList.clear();
        for (Map.Entry<String, IUser> entry : business.getUserMap().entrySet()) {
            userList.add(entry.getKey());
        }
        userListView.setItems(userList);
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
