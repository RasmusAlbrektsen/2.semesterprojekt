/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Acq.ICase;
import business.Case;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
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
import javafx.util.Callback;

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
    private TextArea readDailyNoteField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField CPRTextField;
    @FXML
    private TextField adresseTextField;
    @FXML
    private TextField tlfTextField;
    @FXML
    private TextField sagsbehandlerTextField;
    @FXML
    private Button saveCaseButton;
    @FXML
    private Button updateCaseButton;
    @FXML
    private TextField caseNumber;
    @FXML
    private Label caseLabel;

    private ICase currentCase;
    @FXML
    private Button deleteCaseButton;
    @FXML
    private Button createNoteButton;
    @FXML
    private Tab dailyNoteTab;
    @FXML
    private Label dateOfNote;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public String getCaseInformation() {
        StringBuilder caseCombined = new StringBuilder();
        caseCombined.append(henvendelseTextBox.getText() + "\\},\\{"
                + ydelsesTextBox.getText() + "\\},\\{"
                + henvendelseFraTextBox.getText() + "\\},\\{"
                + aftaleForløbTextBox.getText() + "\\},\\{"
                + værgeMålTexBox.getText() + "\\},\\{"
                + rettighederTextBox.getText() + "\\},\\{"
                + loadOplysningerTextBox.getText() + "\\},\\{"
                + særligeForholdTextBox.getText() + "\\},\\{"
                + kommuneTextBox.getText() + "\\},\\{");
        caseCombined.append(borgerSøgButtonJa.isSelected() + "\\},\\{"
                + borgerSøgButtonNej.isSelected() + "\\},\\{"
                + borgerIndforståetButtonJa.isSelected() + "\\},\\{"
                + borgerIndforståetButtonNej.isSelected() + "\\},\\{"
                + borgerInfoButtonJa.isSelected() + "\\},\\{"
                + borgerInfoButtonNej.isSelected() + "\\},\\{"
                + samtykkeButtonJa.isSelected() + "\\},\\{"
                + samtykkeButtonNej.isSelected() + "\\},\\{"
                + mundtligSamtykkeButton.isSelected() + "\\},\\{"
                + skriftligSamtykkeButton.isSelected() + "\\},\\{");
        caseCombined.append(nameTextField.getText() + "\\},\\{"
                + CPRTextField.getText() + "\\},\\{"
                + adresseTextField.getText() + "\\},\\{"
                + tlfTextField.getText() + "\\},\\{"
                + sagsbehandlerTextField.getText());
        return caseCombined.toString();
    }

    public void loadCaseInformation(String info) {
        String[] caseSplitter = info.split(Pattern.quote("\\},\\{"));
        henvendelseTextBox.setText(caseSplitter[0]);
        ydelsesTextBox.setText(caseSplitter[1]);
        henvendelseFraTextBox.setText(caseSplitter[2]);
        aftaleForløbTextBox.setText(caseSplitter[3]);
        værgeMålTexBox.setText(caseSplitter[4]);
        rettighederTextBox.setText(caseSplitter[5]);
        loadOplysningerTextBox.setText(caseSplitter[6]);
        særligeForholdTextBox.setText(caseSplitter[7]);
        kommuneTextBox.setText(caseSplitter[8]);
        if (caseSplitter[9].equalsIgnoreCase("true")) {
            borgerSøgButtonJa.fire();
        } else {
            borgerSøgButtonNej.fire();
        }
        if (caseSplitter[11].equalsIgnoreCase("true")) {
            borgerIndforståetButtonJa.fire();
        } else {
            borgerIndforståetButtonNej.fire();
        }
        if (caseSplitter[13].equalsIgnoreCase("true")) {
            borgerInfoButtonJa.fire();
        } else {
            borgerInfoButtonNej.fire();
        }
        if (caseSplitter[15].equalsIgnoreCase("true")) {
            samtykkeButtonJa.fire();
        } else {
            samtykkeButtonNej.fire();
        }
        if (caseSplitter[17].equalsIgnoreCase("true")) {
            mundtligSamtykkeButton.fire();
        }
        if (caseSplitter[18].equalsIgnoreCase("true")) {
            skriftligSamtykkeButton.fire();
        }
        nameTextField.setText(caseSplitter[19]);
        CPRTextField.setText(caseSplitter[20]);
        adresseTextField.setText(caseSplitter[21]);
        tlfTextField.setText(caseSplitter[22]);
        sagsbehandlerTextField.setText(caseSplitter[23]);
    }

    @FXML
    private void caseChecklistButtonAction(ActionEvent event) {

        UdredGUI.getInstance().loadController(new Stage(), "BenefitsWindow");
    }

    public void setBenefits(String s) {
        ydelsesTextBox.setText(s);
    }

    @FXML
    private void saveCaseButtonAction(ActionEvent event) {
        System.out.println(getCaseInformation());
        UdredGUI.getInstance().getBusiness().saveCase(CPRTextField.getText(), getCaseInformation());
    }

    public void isAdmin(boolean b) {
        if (b) {
            System.out.println(b);
            deleteCaseButton.setDisable(false);
            deleteCaseButton.setVisible(true);
        }
    }

    public void setCase(ICase aCase) {
        currentCase = aCase;
        loadCaseInformation(currentCase.getInfo());
        getDailyNotes();
        saveCaseButton.setDisable(true);
        saveCaseButton.setVisible(false);
        updateCaseButton.setDisable(false);
        updateCaseButton.setVisible(true);
        caseLabel.setVisible(true);
        caseNumber.setVisible(true);
        CPRTextField.setEditable(false);
        nameTextField.setEditable(false);
        dailyNoteTab.setDisable(false);
        addListenerPaginator();
        readDailyNoteField.setText(currentCase.getDailyNotes().get(dailyNotePagination.getCurrentPageIndex()).getNote());
    }

    public void addListenerPaginator() {
        dailyNotePagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                readDailyNoteField.setText(currentCase.getDailyNotes().get(dailyNotePagination.getCurrentPageIndex()).getNote());
            }
        });
    }

    public void getDailyNotes() {
        dailyNotePagination.setPageCount(currentCase.getDailyNotes().size());
    }

    @FXML
    private void updateCaseButtonAction(ActionEvent event) {
        UdredGUI.getInstance().getBusiness().updateCase(currentCase, getCaseInformation());
    }

    @FXML
    private void deleteCaseButtonAction(ActionEvent event) {
        ButtonType accept = new ButtonType("Accepter", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Annuller", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.NONE,
                "Vil du slette denne sag?",
                accept,
                cancel);

        alert.setTitle("Ændringer til sag!");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == accept) {
            UdredGUI.getInstance().getBusiness().deleteCase(currentCase);
        } else if (result.get() == cancel) {
            alert.close();
        }
    }

    @FXML
    private void createNoteButtonAction(ActionEvent event) {
        UdredGUI.getInstance().getBusiness().saveDailyNote(writeNewDailyNoteField.getText(), currentCase.getCaseNumber());
    }

}
