package commands;

import java.io.File;

/**
 * This factory is part of the command pattern implementation. It contains a
 * method called buildCommand which takes in a String type and uses this String
 * to create the type of command requested.
 *
 */
public class CommandFactory {

    File myProperties;

    /**
     * Create a new command factory used to determine which command object needs
     * to be created
     * 
     */
    public CommandFactory () {
    }

    /**
     * Determine what language the input is in. set the properties file to the
     * one of the appropriate language
     * 
     * @param type
     * @return
     */
    public void checkLanguages (String s) {
        // for each language in the list,
        // language.getString("command in english")
    }

    /**
     * Go through a switch case to determine which Command object needs to be built.
     * 
     * @param type
     * @return
     */
    public Command buildCommand (String type) {
        checkLanguages(type);
        return null;
    }

}
