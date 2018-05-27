package presentation;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class BenefitsWindowController implements Initializable {

    @FXML
    private Button addButton;
    @FXML
    private CheckBox a1;
    @FXML
    private CheckBox a2;
    @FXML
    private CheckBox a3;
    @FXML
    private CheckBox a4;
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
    
    private List<CheckBox> boxList; 
    String benefitString;

    /**
     * Initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boxList = Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13,
                 a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25,
                 a26, a27, a28, a29, a30, a31, a32, a33, a34, a35, a36, a37, a38,
                 a39, a40, a41, a42, a43, a44, a45, a46, a47, a48, a49, a50, a51,
                 a52, a53, a54, a55, a56, a57, a58, a59);
     
    }    
   
    @FXML
    private void addButtonAction(ActionEvent event) {
        benefitString = "";
        for (CheckBox cb : boxList) {
                if(cb.selectedProperty().get()){
                    benefitString += cb.getText() + "\n";
                }
        }
    }
    
    /**
     * Getter for the attribute benefitString.
     * @return String
     */
    public String getBenefitString() {
        return benefitString;
    }
    
    /**
     * Getter for the addButton button.
     * @return Button
     */
    public Button getAddButton() {
        return addButton;
    }
    
    
}
