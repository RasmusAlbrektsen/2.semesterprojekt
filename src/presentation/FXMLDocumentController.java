package presentation;

import Acq.IAppointment;
import Acq.IBusiness;
import Acq.IUser;
import Acq.ICalendar;
import Acq.ICase;
import Acq.IMedicine;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Bruger
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Hyperlink createNewCase;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab mainTab;
    @FXML
    private GridPane frontpageDateGrid;
    @FXML
    private Label frontpageDateLabel;
    @FXML
    private Hyperlink newAppointmentLink;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ListView<String> dailyCalendarListView;
    @FXML
    private Spinner<Integer> hourSpinner;
    @FXML
    private Spinner<Integer> minuteSpinner;
    @FXML
    private DatePicker searchDatePicker;
    @FXML
    private TextField searchCPRField;
    @FXML
    private ListView<String> medicinListView;
    @FXML
    private ListView<HBoxCellCase> caseListView;
    @FXML
    private TextField searchNumberField;
    @FXML
    private Button searchCasesButton;
    @FXML
    private Button myCasesButton;
    @FXML
    private Button addMedicineButton;
    @FXML
    private Button removeMedicineButton;
    @FXML
    private Button allCasesButton;

    private IBusiness business = UdredGUI.getInstance().getBusiness();
    private ObservableList<String> dailyAppointmentList = FXCollections.observableArrayList();
    private ObservableList<String> medicineList = FXCollections.observableArrayList();
    private ObservableList<HBoxCellCase> caseList = FXCollections.observableArrayList();
    private SpinnerValueFactory svf1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 23, 12);
    private SpinnerValueFactory svf2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 30, 10);
    private ICalendar c = business.getCalendar();
    @FXML
    private Button adminWindowButton;
    @FXML
    private Button resetSearchButton;
    @FXML
    private Button openCaseButton;

    private HBoxCellCase selectedCase;

    private int selectedMedicine;

    @FXML
    private Text calendarLabel;
    @FXML
    private VBox calendarVBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dailyCalendarListView.setItems(dailyAppointmentList);
        updateDailyCalendar(business.getCurrentUser());
        svf1.setWrapAround(true);
        svf2.setWrapAround(true);
        hourSpinner.setValueFactory(svf1);
        minuteSpinner.setValueFactory(svf2);
        updateAllCases();

        // Listener for caseListView
        caseListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<HBoxCellCase>() {
            @Override
            public void changed(ObservableValue<? extends HBoxCellCase> observableList, HBoxCellCase oldHBoxCell, HBoxCellCase newHBoxCell) {
                selectedCase = newHBoxCell;
                selectedMedicine = 0;
                if (selectedCase != null) {
                    getCaseMeds(selectedCase.getCase());
                }
            }
        });

        // Listener for medicineListView
        medicinListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValuev, String oldString, String newString) {
                selectedMedicine = medicinListView.getSelectionModel().getSelectedIndex();
            }
        });

        checkAccess();
    }

    private void getCaseMeds(ICase aCase) {
        medicineList.clear();
        for (IMedicine medicine : aCase.getMedicine()) {
            medicineList.add(medicine.toString());
        }
        medicinListView.setItems(medicineList);
    }

    private void checkAccess() {
        if (!business.getCurrentUser().getAdmin()) {
            adminWindowButton.setDisable(true);
            adminWindowButton.setVisible(false);
        }
        if (!business.getCurrentUser().getCaseaccess() && !business.getCurrentUser().getAdmin()) {
            createNewCase.setDisable(true);
            createNewCase.setVisible(false);
            openCaseButton.setDisable(true);
            openCaseButton.setVisible(false);
        }
        if (!business.getCurrentUser().getAppointment()) {
            newAppointmentLink.setDisable(true);
            newAppointmentLink.setVisible(false);
            datePicker.setDisable(true);
            datePicker.setVisible(false);
            hourSpinner.setDisable(true);
            hourSpinner.setVisible(false);
            minuteSpinner.setDisable(true);
            minuteSpinner.setVisible(false);
            calendarLabel.setVisible(false);
            calendarVBox.setDisable(true);
            calendarVBox.setVisible(false);
        }
        if (!business.getCurrentUser().getMedicine()) {
            medicinListView.setDisable(true);
            medicinListView.setVisible(false);
            addMedicineButton.setDisable(true);
            addMedicineButton.setVisible(false);
            removeMedicineButton.setDisable(true);
            removeMedicineButton.setVisible(false);

        }
    }

    @FXML
    private void createNewCaseLinkAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        UdredGUI.getInstance().loadController(stage, "OpenCaseWindow");
    }

    private void updateDailyCalendar(IUser user) {
        frontpageDateLabel.setText(c.getTodaysDateStringDK());
        dailyAppointmentList.clear();
        for (IAppointment appointment : business.getCurrentUser().getAppointments()) {
            if (appointment.getDate().equals(c.formatToDataString(c.getTodaysDateStringDK()))) {
                dailyAppointmentList.add(appointment.getNote());
            }
        }
    }

    @FXML
    private void newAppointmentLinkAction(ActionEvent event) {
        if (datePicker.getValue() != null) {
            LocalDate date = datePicker.getValue();
            String hour = Integer.toString(hourSpinner.getValue());
            String minute = Integer.toString(minuteSpinner.getValue());
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Kalenderaftale");
            dialog.setHeaderText("Kalenderaftale til datoen: " + c.formatLocalDate(date) + " Til tidspunktet: " + hour + ":" + minute);
            dialog.setContentText("Note til aftalen: ");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                business.getCurrentUser().createAppointment(hour + ":" + minute + ": " + dialog.getResult(), c.formatToDataString(c.formatLocalDate(date)), hour + ":" + minute + ":00", business.getCurrentUser().getIDNumber());
            }
            updateDailyCalendar(business.getCurrentUser());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Dato mangler!");
            alert.setContentText("Vælg en dato før du opretter en aftale.");
            alert.showAndWait();
        }
    }

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

    @FXML
    private void searchCasesButtonAction(ActionEvent event) {
        List<ICase> searchResult = new ArrayList<>();
        if (searchDatePicker.getValue() != null && searchCPRField.getText().trim().isEmpty() && searchNumberField.getText().trim().isEmpty()) {
            searchResult = business.searchCases(c.parseDate(searchDatePicker.getValue()));
        }
        if (searchDatePicker.getValue() != null && !searchCPRField.getText().trim().isEmpty() && searchNumberField.getText().trim().isEmpty()) {
            searchResult = business.searchCases(c.parseDate(searchDatePicker.getValue()), searchCPRField.getText());
        }
        if (searchDatePicker.getValue() != null && !searchCPRField.getText().trim().isEmpty() && !searchNumberField.getText().trim().isEmpty()) {
            searchResult = business.searchCases(c.parseDate(searchDatePicker.getValue()), searchCPRField.getText(), (Integer.parseInt(searchNumberField.getText())));
        }
        if (searchDatePicker.getValue() != null && searchCPRField.getText().trim().isEmpty() && !searchNumberField.getText().trim().isEmpty()) {
            searchResult = business.searchCases(c.parseDate(searchDatePicker.getValue()), Integer.parseInt(searchNumberField.getText()));
        }
        if (searchDatePicker.getValue() == null && !searchCPRField.getText().trim().isEmpty() && searchNumberField.getText().trim().isEmpty()) {
            searchResult = business.searchCases(searchCPRField.getText());
        }
        if (searchDatePicker.getValue() == null && !searchCPRField.getText().trim().isEmpty() && !searchNumberField.getText().trim().isEmpty()) {
            searchResult = business.searchCases(searchCPRField.getText(), (Integer.parseInt(searchNumberField.getText())));
        }
        if (searchDatePicker.getValue() == null && searchCPRField.getText().trim().isEmpty() && !searchNumberField.getText().trim().isEmpty()) {
            searchResult = business.searchCases(Integer.parseInt(searchNumberField.getText()));
        }

        selectedCase = null;

        caseList.clear();
        for (ICase iCase : searchResult) {
            caseList.add(new HBoxCellCase(iCase));
        }
        caseListView.setItems(caseList);
    }

    @FXML
    private void myCasesButtonAction(ActionEvent event) {

    }

    @FXML
    private void addMedicineButtonAction(ActionEvent event) {
        Dialog dialog = new Dialog<>();
        dialog.setTitle("Tilføj medicin");
        dialog.setHeaderText("Tilføj medicin til sag");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        ButtonType add = new ButtonType("Tilføj", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Annuller", ButtonBar.ButtonData.CANCEL_CLOSE);

        dialog.getDialogPane().getButtonTypes().addAll(add, cancel);

        TextField name = new TextField();
        name.setPromptText("Indtast navn");
        TextField vnr = new TextField();
        vnr.setPromptText("Indtast VNR");
        TextField dosage = new TextField();
        dosage.setPromptText("Indtast dosering");

        grid.add(new Label("Navn:"), 0, 0);
        grid.add(name, 1, 0);
        grid.add(new Label("VNR:"), 0, 1);
        grid.add(vnr, 1, 1);
        grid.add(new Label("Dosering:"), 0, 2);
        grid.add(dosage, 1, 2);

        dialog.getDialogPane().setContent(grid);
        Optional result = dialog.showAndWait();

        if (result.get() == add && !name.getText().trim().isEmpty()
                && !vnr.getText().trim().isEmpty()
                && !dosage.getText().trim().isEmpty()) {
            selectedCase.getCase().createMedicine(name.getText(), vnr.getText(), dosage.getText());
            updateCaseListView();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("UDFYLD ALLE FELTER!");
            alert.setHeaderText("Medicin kunne ikke tilføjes.");
            alert.showAndWait();
        }
    }

    @FXML
    private void removeMedicineButtonAction(ActionEvent event) {
        selectedCase.getCase().getMedicine().get(selectedMedicine).deleteMedicine(selectedCase.getCase().getCaseNumber(), business.getCurrentUser().getIDNumber());
        updateCaseListView();
    }

    @FXML
    private void allCasesButtonAction(ActionEvent event) {
        updateCaseListView();
    }

    // Might be useless
    private void updateAllCases() {
        caseList.clear();
        for (ICase aCase : business.getCases()) {
            caseList.add(new HBoxCellCase(aCase));
        }
        caseListView.setItems(caseList);
    }

    private void updateCaseListView() {
        medicinListView.getItems().clear();
        business.getCases().clear();
        caseList.clear();
        caseListView.getItems().clear();
        business.setCaseList();
        for (ICase aCase : business.getCases()) {
            caseList.add(new HBoxCellCase(aCase));
        }
        caseListView.setItems(caseList);
    }

    public void updateMyCases() {
        caseList.clear();
        for (ICase aCase : business.getCases()) {

        }
        caseListView.setItems(caseList);
    }

    @FXML
    private void adminWindowAction(ActionEvent event) {
        Stage stage = new Stage();
        UdredGUI.getInstance().loadController(stage, "AdministratorWindow");
    }

    @FXML
    private void resetSearchButtonAction(ActionEvent event) {
        searchDatePicker.setValue(null);
        searchCPRField.clear();
        searchNumberField.clear();
        selectedCase = null;
        updateCaseListView();
    }

    @FXML
    private void openCaseButtonAction(ActionEvent event) {
        Stage stage = new Stage();
        stage.setOnHiding( n -> {updateCaseListView();} );
        OpenCaseWindowController caseWindow = UdredGUI.getInstance().loadController(stage, "OpenCaseWindow").getController();
        caseWindow.setCase(selectedCase.getCase());
        caseWindow.isAdmin(business.getCurrentUser().getAdmin());
    }

}
