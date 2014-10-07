package commands;

import java.util.ResourceBundle;

import commands.turtle_commands.ForwardCommand;

/**
 * This factory is part of the command pattern implementation.
 * It contains a method called buildCommand which takes in a 
 * String type and uses this String to create the type of command
 * requested.
 *
 */
public class CommandFactory {
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    private ResourceBundle myLanguageResources;
    public static final ResourceBundle myCommandResources = 
            ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Commands");

    public CommandFactory (String language) {
        myLanguageResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE 
                + "languages/" + language);

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
        Command newCommand = new ForwardCommand();
        return null;
    }

}
