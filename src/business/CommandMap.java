/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.HashMap;

/**
 *
 * @author Bruger
 */

public class CommandMap {
    private HashMap<String, CommandEnum> availableCommands;

    public CommandMap() {
        availableCommands = new HashMap<String, CommandEnum>();
        for(CommandEnum command : CommandEnum.values()) {
            if(command != CommandEnum.UNKNOWN) {
                availableCommands.put(command.toString(), command);
            }
        }
    }

    public CommandEnum getCommandWord(String commandWord) {
        CommandEnum command = availableCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandEnum.UNKNOWN;
        }
    }
    
    public boolean isCommand(String aString) {
        return availableCommands.containsKey(aString);
    }

    public void showAll() {
        for(String command : availableCommands.keySet()) {
            java.lang.System.out.print(command + "  ");
        }
        java.lang.System.out.println();
    }
}
