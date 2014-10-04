package commands;

/**
 * This factory is part of the command pattern implementation.
 * It contains a method called buildCommand which takes in a 
 * String type and uses this String to create the type of command
 * requested.
 *
 */
public class CommandFactory {

    public CommandFactory () {
    }
    
    public void checkLanguages(){
        //for each language in the list, language.getString("command in english")
    }

    /**
     * 
     * @param type
     * @return
     */
    public Command buildCommand (String type) {
        Command newCommany = new ForwardCommand();
        return null;
    }

}
