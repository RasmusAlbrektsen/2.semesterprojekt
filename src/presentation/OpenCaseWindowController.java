/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class OpenCaseWindowController implements Initializable {

    @FXML
    private ToggleGroup lookingForGroup;
    @FXML
    private Button caseChecklistButton;
    @FXML
    private ToggleGroup inqButtons;
    @FXML
    private ToggleGroup elInformation;
    @FXML
    private ToggleGroup consent;
    @FXML
    private ToggleGroup consentInfo;
    @FXML
    private TextArea writeNewDailyNoteField;
    @FXML
    private Pagination dailyNotePagination;
    @FXML
    private TextField dailyNoteNameField;
    @FXML
    private TextArea readDailyNoteField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void caseChecklistButtonAction(ActionEvent event) {
         try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("BenefitsWindow.fxml"));
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            
        }
    }

    
}
