package presentation;

import Acq.ICase;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HBoxCellCase extends HBox{
    private Label IDnum = new Label();
    private Label CPR = new Label();
    private Label creationDate = new Label();
    private ICase aCase;

    public HBoxCellCase(ICase aCase) {
        super(10);
        this.aCase = aCase;
        
        this.IDnum.setText("Sags ID: " + Integer.toString(aCase.getCaseNumber()));
        this.CPR.setText("Borger CPR: " + aCase.getCPR());
        this.creationDate.setText("Oprettelsesdato: " + aCase.getCreationDate());
        
        this.getChildren().addAll(this.IDnum, this.CPR, this.creationDate);
    }
    
    /**
     * Getter for the attribute aCase
     * @return ICase
     */
    public ICase getCase(){
        return aCase;
    }
}
