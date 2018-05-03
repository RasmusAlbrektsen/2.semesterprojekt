/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

    public enum CommandEnum {
        CREATE("create"), UPDATE("update"), LOGIN("login"), QUIT("quit"), HELP("help"), UNKNOWN("?"),;
    
        private String commandString;
    
        CommandEnum(String commandString){
            this.commandString = commandString;
        }
    
        public String toString() {
            return commandString;
        }
}
