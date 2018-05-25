
import Acq.IBusiness;
import Acq.ICase;
import Acq.IData;
import Acq.IGUI;
import Acq.IUser;
import business.Business;
import business.BusinessFacade;
import business.Case;
import business.User;
import data.DataFacade;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import presentation.GUIFacade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kasper
 */
public class TestingClass  extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        IGUI gui = new GUIFacade();
        IBusiness business = new BusinessFacade();
        IData data = new DataFacade();
        gui.injectBusiness(business);
        business.injectData(data);
        Business.getInstance().setData(data);
        Business.getInstance().setCaseList();
        gui.start(primaryStage);
        
        
       
        
        business.setUserMap();
        
        System.out.println(data.getAllCases());
        System.out.println(data.getAllUsers());
        
        

        
        

        
        
        IUser user = new User("navn", "brugernavn", "password");
        user.createAppointment("note", "2451-05-12", "18:20:20", 0);
        user.updateAppointment(user.getAppointments().get(0), "", "", "");
        user.removeAppointment(user.getAppointments().get(0));

        
        ICase aCase = new Case("254585756585", "aaaaaaaaaaaaaaaaaaaaaaaaaaaa\\},\\{Aktivitets- og samværsydelse\n støtte til personlig pleje\n pasning af pårørende\n ungdomsuddannelse for unge med \n særlige behov\n forsorgshjem/herberg\n \\},\\{ssssssssssssssssssssssssssssssss\\},\\{jjjjjjjjjjjjjjjjjjjjj\\},\\{kkkkkkkkkkkkkkkkk\\},\\{lllllllllllllllll\\},\\{ææææææææææææææææææ\\},\\{mmmmmmmmmmmmmmmmmmmmmmmm\\},\\{tttttttttttttttttttttttttttttt\\},\\{true\\},\\{false\\},\\{true\\},\\{false\\},\\{true\\},\\{false\\},\\{true\\},\\{false\\},\\{false\\},\\{true\\},\\{Hans Peter\\},\\{1234567890\\},\\{Gammelmandsvej 37\\},\\{88888888\\},\\{Henritte Hansen");
        aCase.createDailyNote("note");
        aCase.createMedicine("name", "vnr", "dose");
        aCase.removeMedicine(user.getIDNumber(), 0);
        aCase.saveCase(user.getIDNumber());
        aCase.updateCase(user.getIDNumber(), "aaaaaaaaaaaaaaaaaaaaaaaaaaaa\\},\\{Aktivitets- og samværsydelse\n støtte til personlig pleje\n pasning af pårørende\n ungdomsuddannelse for unge med \n særlige behov\n forsorgshjem/herberg\n \\},\\{ssssssssssssssssssssssssssssssss\\},\\{jjjjjjjjjjjjjjjjjjjjj\\},\\{kkkkkkkkkkkkkkkkk\\},\\{lllllllllllllllll\\},\\{ææææææææææææææææææ\\},\\{mmmmmmmmmmmmmmmmmmmmmmmm\\},\\{tttttttttttttttttttttttttttttt\\},\\{true\\},\\{false\\},\\{true\\},\\{false\\},\\{true\\},\\{false\\},\\{true\\},\\{false\\},\\{false\\},\\{true\\},\\{Hans Peter\\},\\{1234567890\\},\\{Gammelmandsvej 37\\},\\{88888888\\},\\{Henritte Hansen");
        aCase.updateMedicine(aCase.getMedicine().get(0), "amount", "dose");
        aCase.deleteCase(user.getIDNumber());
        
        
        
        user.deleteUser(user.getIDNumber());        
    }
    
    
    
}