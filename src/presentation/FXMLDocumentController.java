package presentation;

import business.Calendar;
import business.User;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private Tab sagTab;
    @FXML
    private GridPane frontpageDateGrid;
    @FXML
    private Label frontpageDateLabel;
    @FXML
    private AnchorPane sagAnchor;
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
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void createNewCaseLinkAction(ActionEvent event) throws IOException {
        AnchorPane root = new AnchorPane();
        
        
        
        tabPane.getTabs().add(new Tab("Ny sag", root));
        
    }
    
}
