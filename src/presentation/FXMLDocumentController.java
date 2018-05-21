package presentation;

import Acq.IAppointment;
import Acq.IBusiness;
import Acq.IUser;
import Acq.ICalendar;
import Acq.ICase;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
import javafx.scene.layout.GridPane;
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
    private ChoiceBox<?> monthSelectorBox;
    @FXML
    private Text firstDayText;
    @FXML
    private Text seconddDayText;
    @FXML
    private Text thirddDayText;
    @FXML
    private Text fourthDayText;
    @FXML
    private Text fifthDayText;
    @FXML
    private Text sixthDayText;
    @FXML
    private Text seventhDayText;
    @FXML
    private Hyperlink newAppointmentLink;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ToggleGroup lookingForGroup;
    @FXML
    private ToggleGroup inqButtons;
    @FXML
    private ToggleGroup elInformation;
    @FXML
    private ToggleGroup consent;
    @FXML
    private ToggleGroup consentInfo;
    @FXML
    private Tab newCaseTab;
    @FXML
    private Tab calendarTab;
    @FXML
    private Hyperlink openCalendarLink;
    @FXML
    private Button caseChecklistButton;
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
    private ListView<?> medicinListView;
    @FXML
    private ListView<HBoxCell> caseListView;
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
    private ObservableList<HBoxCell> caseList = FXCollections.observableArrayList();
    private SpinnerValueFactory svf1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 23, 12);
    private SpinnerValueFactory svf2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 30, 10);
    private ICalendar c = business.getCalendar();
    @FXML
    private Button adminWindowButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dailyCalendarListView.setItems(dailyAppointmentList);
        updateDailyCalendar(business.getCurrentUser());
        svf1.setWrapAround(true);
        svf2.setWrapAround(true);
        hourSpinner.setValueFactory(svf1);
        minuteSpinner.setValueFactory(svf2);
        updateAllCases();

    }

    @FXML
    private void createNewCaseLinkAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        UdredGUI.getInstance().loadController(stage, "OpenCaseWindow");
    }

    private void updateDailyCalendar(IUser user) {
        frontpageDateLabel.setText(c.getTodaysDateString());
        dailyAppointmentList.clear();
        for (IAppointment appointment : business.getCurrentUser().getAppointments()) {
            if (appointment.getDate().equals(c.formatToDataString(c.getTodaysDateString()))) {
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
        
        caseList.clear();
        for (ICase iCase : searchResult) {
            caseList.add(new HBoxCell(iCase));
        }
        caseListView.setItems(caseList);
    }

    @FXML
    private void myCasesButtonAction(ActionEvent event) {

    }

    @FXML
    private void addMedicineButtonAction(ActionEvent event) {
    }

    @FXML
    private void removeMedicineButtonAction(ActionEvent event) {
    }

    @FXML
    private void allCasesButtonAction(ActionEvent event) {
        updateAllCases();
    }

    public void updateAllCases() {
        caseList.clear();
        for (ICase aCase: business.getCases()) {
            caseList.add(new HBoxCell(aCase));
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
}
