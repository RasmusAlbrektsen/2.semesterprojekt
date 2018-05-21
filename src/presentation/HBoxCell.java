/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Acq.ICase;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author rasmusstamm
 */
public class HBoxCell extends HBox{
    private Label IDnum = new Label();
    private Label CPR = new Label();
    private Label creationDate = new Label();
    private ICase aCase;

    public HBoxCell(ICase aCase) {
        super(10);
        this.aCase = aCase;
        
        this.IDnum.setText("Sags ID: " + Integer.toString(aCase.getCaseNumber()));
        this.CPR.setText("Borger CPR: " + aCase.getCPR());
        this.creationDate.setText("Oprettelsesdato: " + aCase.getCreationDate());
        
        this.getChildren().addAll(this.IDnum, this.CPR, this.creationDate);
        
    }
    
    
}
