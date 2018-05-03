/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Bruger
 */
public class Command {
    
    private CommandEnum commandWord;
    private String secondWord;

    public Command(CommandEnum commandWord)
    {
        this.commandWord = commandWord;
    }

    public CommandEnum getCommandWord()
    {
        return commandWord;
    }

    public String getSecondWord()
    {
        return secondWord;
    }

    public boolean isUnknown()
    {
        return (commandWord == CommandEnum.UNKNOWN);
    }

}

