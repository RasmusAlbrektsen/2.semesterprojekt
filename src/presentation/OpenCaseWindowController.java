package presentation;

import Acq.ICase;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Pagination;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OpenCaseWindowController implements Initializable {

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
    @FXML
    private Button deleteCaseButton;
    @FXML
    private Tab dailyNoteTab;
    @FXML
    private Label dateOfNote;
    @FXML
    private Tab benefitsTab;
    @FXML
    private CheckBox a1;
    @FXML
    private CheckBox a2;
    @FXML
    private CheckBox a3;
    @FXML
    private CheckBox a5;
    @FXML
    private CheckBox a6;
    @FXML
    private CheckBox a7;
    @FXML
    private CheckBox a8;
    @FXML
    private CheckBox a9;
    @FXML
    private CheckBox a10;
    @FXML
    private CheckBox a11;
    @FXML
    private CheckBox a12;
    @FXML
    private CheckBox a13;
    @FXML
    private CheckBox a14;
    @FXML
    private CheckBox a15;
    @FXML
    private CheckBox a16;
    @FXML
    private CheckBox a17;
    @FXML
    private CheckBox a18;
    @FXML
    private CheckBox a19;
    @FXML
    private CheckBox a20;
    @FXML
    private CheckBox a21;
    @FXML
    private CheckBox a22;
    @FXML
    private CheckBox a23;
    @FXML
    private CheckBox a24;
    @FXML
    private CheckBox a25;
    @FXML
    private CheckBox a26;
    @FXML
    private CheckBox a27;
    @FXML
    private CheckBox a28;
    @FXML
    private CheckBox a29;
    @FXML
    private CheckBox a30;
    @FXML
    private CheckBox a31;
    @FXML
    private CheckBox a32;
    @FXML
    private CheckBox a33;
    @FXML
    private CheckBox a34;
    @FXML
    private CheckBox a35;
    @FXML
    private CheckBox a36;
    @FXML
    private CheckBox a37;
    @FXML
    private CheckBox a38;
    @FXML
    private CheckBox a39;
    @FXML
    private CheckBox a40;
    @FXML
    private CheckBox a41;
    @FXML
    private CheckBox a42;
    @FXML
    private CheckBox a43;
    @FXML
    private CheckBox a44;
    @FXML
    private CheckBox a45;
    @FXML
    private CheckBox a46;
    @FXML
    private CheckBox a47;
    @FXML
    private CheckBox a48;
    @FXML
    private CheckBox a49;
    @FXML
    private CheckBox a50;
    @FXML
    private CheckBox a51;
    @FXML
    private CheckBox a52;
    @FXML
    private CheckBox a53;
    @FXML
    private CheckBox a54;
    @FXML
    private CheckBox a55;
    @FXML
    private CheckBox a56;
    @FXML
    private CheckBox a57;
    @FXML
    private CheckBox a58;
    @FXML
    private CheckBox a59;
    @FXML
    private CheckBox a60;
    @FXML
    private Button addButton;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab caseTab;    
    
    private ICase currentCase;
    private String benefitString;
    private List<CheckBox> boxList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boxList = Arrays.asList(a1, a2, a3, a5, a6, a7, a8, a9, a10, a11, a12, a13,
                a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25,
                a26, a27, a28, a29, a30, a31, a32, a33, a34, a35, a36, a37, a38,
                a39, a40, a41, a42, a43, a44, a45, a46, a47, a48, a49, a50, a51,
                a52, a53, a54, a55, a56, a57, a58, a59, a60);
    }

    /**
     * Gets the information that's written in the textAreas.
     * @return 
     */
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

    /**
     * Loads the case with the information that was saved.
     * @param info 
     */
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
        caseNumber.setText(Integer.toString(currentCase.getCaseNumber()));
    }

    @FXML
    private void caseChecklistButtonAction(ActionEvent event) {
        tabPane.getSelectionModel().select(benefitsTab);
    }

    /**
     * Setter for the ydelsesTextBox TextBox
     * @param s 
     */
    public void setBenefits(String s) {
        ydelsesTextBox.setText(s);
    }

    @FXML
    private void saveCaseButtonAction(ActionEvent event) {
        if (nameTextField.getText().isEmpty() || CPRTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Felter er tomme!");
            alert.setContentText("Udfyld felterne (Navn og CPR) inden du prøver at gemme sagen");
            alert.showAndWait();
        } else {
            UdredGUI.getInstance().getBusiness().saveCase(CPRTextField.getText(), getCaseInformation());
            closeWindow(event);
        }
    }

    /**
     * Enables and disables the deleteCaseButton depending on if the boolean is true of false.
     * @param b 
     */
    public void isAdmin(boolean b) {
        if (b) {
            deleteCaseButton.setDisable(false);
            deleteCaseButton.setVisible(true);
        }
    }

    /**
     * Resets the window.
     * @param aCase 
     */
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
        if (!currentCase.getDailyNotes().isEmpty()) {
            readDailyNoteField.setText(currentCase.getDailyNotes().get(dailyNotePagination.getCurrentPageIndex()).getNote());
            dateOfNote.setText(currentCase.getDailyNotes().get(dailyNotePagination.getCurrentPageIndex()).getDate());
        }
    }

    /**
     * Checks if you changed page, in the dailyNote window.
     */
    public void addListenerPaginator() {
        dailyNotePagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                readDailyNoteField.setText(currentCase.getDailyNotes().get(dailyNotePagination.getCurrentPageIndex()).getNote());
                dateOfNote.setText(currentCase.getDailyNotes().get(dailyNotePagination.getCurrentPageIndex()).getDate());
            }
        });
    }

    /**
     * Sets the pageCount in the dailyNote window to the size of the dailyNotes.
     */
    public void getDailyNotes() {
        dailyNotePagination.setPageCount(currentCase.getDailyNotes().size());
    }

    @FXML
    private void updateCaseButtonAction(ActionEvent event) {
        UdredGUI.getInstance().getBusiness().updateCase(currentCase, getCaseInformation());
        closeWindow(event);
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
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            
        } else if (result.get() == cancel) {
            alert.close();
        }
        closeWindow(event);
    }

    @FXML
    private void createNoteButtonAction(ActionEvent event) {
        UdredGUI.getInstance().getBusiness().saveDailyNote(writeNewDailyNoteField.getText(), currentCase.getCaseNumber());
    }

    @FXML
    private void addButtonAction(ActionEvent event) {
        benefitString = "";
        for (CheckBox cb : boxList) {
            if (cb.selectedProperty().get()) {
                benefitString += cb.getText() + "\n";
            }
        }
        ydelsesTextBox.setText(benefitString);
        tabPane.getSelectionModel().select(caseTab);
    }
    
    /**
     * Closes the window
     * @param event 
     */
    private void closeWindow(Event event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
