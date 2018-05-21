/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Kasper Møller
 */
public class BenefitsWindowController implements Initializable {
    @FXML
    private static AnchorPane anchorPane;
    private static List<CheckBox> checkBoxList;
    @FXML
    private Button addButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public List getToggles(){
        for (Object col : anchorPane.getChildren()) {
            if (col instanceof CheckBox){
                if(((CheckBox) col).isArmed()){
                    checkBoxList.add((CheckBox) col);
                }
            }
        }
        return checkBoxList;
    }

    @FXML
    private void addButtonAction(ActionEvent event) {
        StringBuilder s = new StringBuilder();
        for (Object col : anchorPane.getChildren()) {
            if (col instanceof CheckBox){
                if(((CheckBox) col).isArmed()){
                    s.append(col.toString() + "\n");
                }
            }
        }
    }
    
    
}
