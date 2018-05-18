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
import javafx.scene.control.RadioButton;
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
    private TextArea henvendelseTextBox;
    @FXML
    private TextArea ydelsesTextBox;
    @FXML
    private TextArea henvendelseFraTextBox;
    @FXML
    private TextArea aftaleForløbTextBox;
    @FXML
    private TextArea værgeMålTexBox;
    @FXML
    private TextArea rettighederTextBox;
    @FXML
    private TextArea loadOplysningerTextBox;
    @FXML
    private TextArea særligeForholdTextBox;
    @FXML
    private TextArea kommuneTextBox;
    @FXML
    private RadioButton borgerSøgButtonJa;
    @FXML
    private RadioButton borgerSøgButtonNej;
    @FXML
    private RadioButton borgerIndforståetButtonJa;
    @FXML
    private RadioButton borgerIndforståetButtonNej;
    @FXML
    private RadioButton borgerInfoButtonJa;
    @FXML
    private RadioButton borgerInfoButtonNej;
    @FXML
    private RadioButton samtykkeButtonJa;
    @FXML
    private RadioButton samtykkeButtonNej;
    @FXML
    private RadioButton mundtligSamtykkeButton;
    @FXML
    private RadioButton skriftligSamtykkeButton;
    @FXML
    private TextArea writeNewDailyNoteField;
    @FXML
    private Pagination dailyNotePagination;
    @FXML
    private TextField dailyNoteNameField;
    @FXML
    private TextArea readDailyNoteField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField cPRTextField;
    @FXML
    private TextField adresseTextField;
    @FXML
    private TextField tlfTextField;
    @FXML
    private TextField sagsbehandlerTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public String getCaseInformation() {
        StringBuilder caseCombined = new StringBuilder();
        caseCombined.append(henvendelseTextBox.getText() + "\\" + ydelsesTextBox.getText() + "\\" + henvendelseFraTextBox.getText() + "\\" + aftaleForløbTextBox.getText() + "\\" + værgeMålTexBox.getText() + "\\" + rettighederTextBox.getText() + "\\" + loadOplysningerTextBox.getText() + "\\" + særligeForholdTextBox.getText() + "\\" + kommuneTextBox.getText());
        caseCombined.append(borgerSøgButtonJa.isSelected() + "\\"
                + borgerSøgButtonNej.isSelected() + "\\"
                + borgerIndforståetButtonJa.isSelected() + "\\"
                + borgerIndforståetButtonNej.isSelected() + "\\"
                + borgerInfoButtonJa.isSelected() + "\\"
                + borgerInfoButtonNej.isSelected() + "\\"
                + samtykkeButtonJa.isSelected() + "\\"
                + samtykkeButtonNej.isSelected() + "\\"
                + mundtligSamtykkeButton.isSelected() + "\\"
                + skriftligSamtykkeButton.isSelected());
        caseCombined.append(nameTextField.getText() + "\\" + cPRTextField.getText() + "\\" + adresseTextField.getText() + "\\" + tlfTextField.getText() + "\\" + sagsbehandlerTextField.getText());
        return caseCombined.toString();
    }

    public void loadCaseInformation(String string) {
        String[] caseSplitter = string.split("\\");
        henvendelseTextBox.setText(caseSplitter[0]);
        ydelsesTextBox.setText(caseSplitter[1]);
        henvendelseFraTextBox.setText(caseSplitter[2]);
        aftaleForløbTextBox.setText(caseSplitter[3]);
        værgeMålTexBox.setText(caseSplitter[4]);
        rettighederTextBox.setText(caseSplitter[5]);
        loadOplysningerTextBox.setText(caseSplitter[6]);
        særligeForholdTextBox.setText(caseSplitter[7]);
        kommuneTextBox.setText(caseSplitter[8]);
        if(caseSplitter[9].equalsIgnoreCase("true")) {
          borgerSøgButtonJa.fire();
        } else {
            borgerSøgButtonNej.fire();
        }
        if(caseSplitter[11].equalsIgnoreCase("true")) {
            borgerIndforståetButtonJa.fire();
        } else {
            borgerIndforståetButtonNej.fire();
        }
        if(caseSplitter[13].equalsIgnoreCase("true")) {
            borgerInfoButtonJa.fire();
        } else {
            borgerInfoButtonNej.fire();
        }
        if(caseSplitter[15].equalsIgnoreCase("true")) {
            samtykkeButtonJa.fire();
        } else {
            samtykkeButtonNej.fire();
        }
        if(caseSplitter[17].equalsIgnoreCase("true")) {
            mundtligSamtykkeButton.fire();
        } 
        if(caseSplitter[18].equalsIgnoreCase("true")) {
            skriftligSamtykkeButton.fire();
        }
        nameTextField.setText(caseSplitter[19]);
        cPRTextField.setText(caseSplitter[20]);
        adresseTextField.setText(caseSplitter[21]);
        tlfTextField.setText(caseSplitter[22]);
        sagsbehandlerTextField.setText(caseSplitter[23]);
    }

    @FXML
    private void caseChecklistButtonAction(ActionEvent event) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("BenefitsWindow.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

        }
    }

}
