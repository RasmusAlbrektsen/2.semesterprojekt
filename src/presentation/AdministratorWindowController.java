/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Acq.IBusiness;
import Acq.ICase;
import Acq.ICaseLog;
import Acq.IUser;
import Acq.IUserLog;
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
        business.setCaseLogs();
        business.setUserLogs();
        updateUserListView();
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
        if (user.getAdmin() == true) {
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

    @FXML
    private void removeUserAction(ActionEvent event) {
        IUser user = business.getUserMap().get(usernameField.getText());
        ButtonType delete = new ButtonType("Slet", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Annuller", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(AlertType.NONE,
                "Er du sikker på at du vil slette brugeren: "
                + usernameField.getText(),
                delete,
                cancel);

        alert.setTitle("Bruger slettes!");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == delete) {
            user.deleteUser(business.getCurrentUser().getIDNumber());
        } else if (result.get() == cancel) {
            alert.close();
        }
        updateUserListView();
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
        user.updateUser(business.getCurrentUser().getIDNumber());
        updateUserListView();
    }

    @FXML
    private void createNewUserAction(ActionEvent event) {
        if (!business.getUserMap().containsKey(usernameField.getText()) && checkBoxes() == true) {
            ButtonType save = new ButtonType("Gem", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancel = new ButtonType("Annuller", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(AlertType.NONE,
                    "Vil du oprette denne bruger?" + "\n" + nameField.getText()
                    + "\n" + usernameField.getText() + "\n" + passwordField.getText(),
                    save,
                    cancel);

            alert.setTitle("Ny bruger!");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == save) {
                business.saveUser(nameField.getText(), usernameField.getText(), passwordField.getText());
            } else if (result.get() == cancel) {
                alert.close();
            }
        }
        updateUserListView();
    }

    private boolean checkBoxes() {
        if (!usernameField.getText().trim().isEmpty()
                && !nameField.getText().trim().isEmpty()
                && !passwordField.getText().trim().isEmpty()) {
            return true;
        } else {
            ButtonType ok = new ButtonType("Okay", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(AlertType.NONE,
                    "Information mangler! Udfyld alle felter",
                    ok);

            alert.setTitle("Felt ikke udfyldt");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ok) {
                business.saveUser(nameField.getText(), usernameField.getText(), passwordField.getText());
            }
            return false;
        }
    }

    private void updateUserListView() {
        business.getUserMap().clear();
        userList.clear();
        userListView.getItems().clear();
        business.setUserMap();
        for (Map.Entry<String, IUser> entry : business.getUserMap().entrySet()) {
            userList.add(entry.getKey());
        }
        userListView.setItems(userList);
    }

    @FXML
    private void showUserLogAction(ActionEvent event) {
        logList.clear();
        for (IUserLog userlog : business.getUserLog()) {
            logList.add(userlog.toString());
        }
        logListView.setItems(logList);
    }

    @FXML
    private void showCaseLogAction(ActionEvent event) {
        logList.clear();
        for (ICaseLog caselog : business.getCaseLog()) {
            logList.add(caselog.toString());
        }
        logListView.setItems(logList);
    }

}
