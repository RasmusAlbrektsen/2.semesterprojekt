package presentation;

import business.Calendar;
import business.User;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
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
    private TextArea todaysCalendarField;
    
    private Calendar c = new Calendar();
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
    
    private User user = new User("ralle", "ralle", 10, 10);
    @FXML
    private Tab newCaseTab;
    @FXML
    private Tab calendarTab;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateDailyCalendar(user);
    }    

    @FXML
    private void createNewCaseLinkAction(ActionEvent event) throws IOException {
        
    }
    
    private void updateDailyCalendar(User user) {
        todaysCalendarField.setText(c.getDailyAppointments(c.getTodaysDate(), user));
        frontpageDateLabel.setText(c.getTodaysDate());
    }

    @FXML
    private void newAppointmentLinkAction(ActionEvent event) {
        if(datePicker.getValue() != null) {
        LocalDate date = datePicker.getValue();
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Kalenderaftale");
        dialog.setHeaderText("Kalenderaftale til datoen: " + c.formatLocalDate(date));
        dialog.setContentText("Note til aftalen: ");

        Optional<String> result = dialog.showAndWait();
        if(result.isPresent()) {
            user.createAppointment(c.formatLocalDate(date), "Ingen cpr", dialog.getResult(), user.getIDNumber());
        }
        updateDailyCalendar(user); 
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Dato mangler!");
            alert.setContentText("Vælg en dato før du opretter en aftale.");
            alert.showAndWait();
        }
    }    
}
