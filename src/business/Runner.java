/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Scanner;

/**
 *
 * @author Bruger
 */
public class Runner {
    private Parser parser;
    private boolean loggedIn = false;

    public Runner() {
        parser = new Parser();
    }
    
    
    public void run() 
    {            
        
        printHelp();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = commandSwitch(command);
        }
        java.lang.System.out.println("System closing...");
    }
    
     public boolean login(String username, String password) {
        return true;
    }
     
     private boolean commandSwitch(Command command) 
    {
        boolean wantToQuit = false;
        CommandEnum commandWord = command.getCommandWord();

        switch (commandWord) {
            
            case UNKNOWN: java.lang.System.out.println("\nThe command isn't valid, here are the commands: \n");
            printHelp();
            break;
            
            case CREATE: 
            break;
            
            case UPDATE: 
            break;
            
            case LOGIN:  
                
            break;
            
            case HELP: printHelp();
            break;
            
            case QUIT: wantToQuit = true;
            break;
            
        }
        return wantToQuit;
    }
    
    /**
     * Prints a message showing the commands available.
     */
    private void printHelp() 
    {
        java.lang.System.out.println("Here's a list over the available commands:\n");
        java.lang.System.out.println("login: Log in to acces the system. \n");
        java.lang.System.out.println("create: Create a new case or appointment. \n");
        java.lang.System.out.println("update: Update a case or an appointment \n");
        java.lang.System.out.println("quit: Exits the system.\n");
        
        parser.showCommands();
        java.lang.System.out.println("Type your command: ");
    }
}
