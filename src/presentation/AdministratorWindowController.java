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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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
    private Button showUsersButton;
    @FXML
    private Button removeUserButton;
    @FXML
    private Button updateUserButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private RadioButton logAccessRadio;
    @FXML
    private RadioButton medicineAccessRadio;
    @FXML
    private RadioButton calendarAccessRadio;
    @FXML
    private RadioButton caseAccessRadio;
    @FXML
    private Button createNewUserButton;
    
    private IBusiness business = UdredGUI.getInstance().getBusiness();
    private ObservableList<String> userList = FXCollections.observableArrayList();
    private ObservableList<String> logList = FXCollections.observableArrayList();
    private String selectedUser;
    @FXML
    private Button showUserLogButton;
    @FXML
    private Button showCaseLogButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showUsers();
        userListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectedUser = newValue;
                changeUserInfo(selectedUser);
            }
        });
    }

    private void changeUserInfo(String username) {
        IUser user;
        user = business.getUserMap().get(username);
        nameField.setText(user.getName());
        usernameField.setText(user.getUsername());
        passwordField.setText(user.getPassword());
        if (user.getLog() == true) {
            logAccessRadio.setSelected(true);
        } else {
            logAccessRadio.setSelected(false);
        }
        if (user.getAppointment() == true) {
            calendarAccessRadio.setSelected(true);
        } else {
            calendarAccessRadio.setSelected(false);
        }
        if (user.getMedicine() == true) {
            medicineAccessRadio.setSelected(true);
        } else {
            medicineAccessRadio.setSelected(false);
        }
        if (user.getCaseaccess() == true) {
            caseAccessRadio.setSelected(true);
        } else {
            caseAccessRadio.setSelected(false);
        }

    }

    public void showUsers() {
        userList.clear();
        for (Map.Entry<String, IUser> entry : business.getUserMap().entrySet()) {
            userList.add(entry.getKey());
        }
        userListView.setItems(userList);
    }


    @FXML
    private void removeUserAction(ActionEvent event) {
    }

    @FXML
    private void updateUserAction(ActionEvent event) {
        if (business.getUserMap().containsKey(usernameField.getText())) {
            IUser user = business.getUserMap().get(usernameField.getText());
            ButtonType save = new ButtonType("Gem", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancel = new ButtonType("Annuller", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(AlertType.NONE,
                    "Vil du gemme disse ændringer?",
                    save,
                    cancel);

            alert.setTitle("Ændringer til bruger!");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == save) {
                updateUserInformation(user);
            } else if (result.get() == cancel) {
                alert.close();
            }
        } else {
            
        }
    }
    
    private void updateUserInformation(IUser user) {
        user.setName(nameField.getText());
                user.setPassword(passwordField.getText());
                //Set access for user
                if (logAccessRadio.isSelected()) {
                    user.setLog(true);
                } else {
                    user.setLog(false);
                }
                if (calendarAccessRadio.isSelected()) {
                    user.setAppointment(true);
                } else {
                    user.setAppointment(false);
                }
                if (medicineAccessRadio.isSelected()) {
                    user.setMedicine(true);
                } else {
                    user.setMedicine(false);
                }
                if (caseAccessRadio.isSelected()) {
                    user.setCaseAccess(true);
                } else {
                    user.setCaseAccess(false);
                }
                user.updateUser();
    }

    private void showLogAction(ActionEvent event) {
        logList.clear();
        
    }

    @FXML
    private void createNewUserAction(ActionEvent event) {
       
    }
    
    private void updateUseListView() {
        
    }

    @FXML
    private void showUserLogAction(ActionEvent event) {
    }

    @FXML
    private void showCaseLogAction(ActionEvent event) {
    }


}
