/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Acq.IBusiness;
import business.Business;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nitra
 */
public class LoginWindowController implements Initializable {
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Button logInButton;
    @FXML
    private AnchorPane loginPane;

    private IBusiness r = UdredGUI.getInstance().getBusiness();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void loginButtonAction(ActionEvent event) {
        if(r.login(usernameField.getText(), passwordField.getText()) == true) {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            loadMainWindow();
            
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Fejl!");
            alert.setContentText("Brugernavn eller password matcher ikke!");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void loginButtonKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            if(r.login(usernameField.getText(), passwordField.getText()) == true) {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            loadMainWindow();
            
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Fejl!");
            alert.setContentText("Brugernavn eller password matcher ikke!");
            alert.showAndWait();
        }
        }
    }
    
    private void loadMainWindow() {
        try {
            Stage stage = new Stage();
            stage.setTitle("Sensum Udred");
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setMinHeight(800);
            stage.setMinWidth(1280);
            
            stage.setScene(scene);
            stage.showAndWait();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
