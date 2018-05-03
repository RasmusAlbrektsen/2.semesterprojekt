/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Bruger
 */
public class Parser {


private CommandMap commands;
    
private Scanner reader;

    

public Parser() {

    commands = new CommandMap();
        
    reader = new Scanner(java.lang.System.in);
}

   

 public Command getCommand() {
    
    String inputLine;
    String word = null;   

    java.lang.System.out.print("> ");

    inputLine = reader.nextLine();

    Scanner tokenizer = new Scanner(inputLine);
      
    if(tokenizer.hasNext()) {
        word = tokenizer.next();
    }
    return new Command(commands.getCommandWord(word));
  }

    public void showCommands(){
        commands.showAll();
    }
}