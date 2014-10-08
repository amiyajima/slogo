package commands;

import java.util.ResourceBundle;


/**
 * This factory is part of the command pattern implementation.
 * It contains a method called buildCommand which takes in a
 * String type and uses this String to create the type of command
 * requested.
 *
 */
public class CommandFactory {
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    public static final ResourceBundle myCommandResources =
            ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Commands");
    private ResourceBundle myLanguageResources;
    private String classKey;

    /**
     * Initializes a command factory
     * 
     * @param language The language commands are being put into the text field
     */
    public CommandFactory (String language) {
        myLanguageResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE
                                                       + "languages/" + language);

    }

    /**
     * Searches to see if the command given is can be found in the selected
     * language properties file. If it can, return true, if not false.
     * 
     * @param type command type being checked
     * @return Return true if the command is valid
     */
    private boolean checkLanguage (String type) {
        for (String s : myLanguageResources.keySet()) {
            String[] possibilities = myLanguageResources.getString(s).split(",");
            for (String possibility : possibilities) {
                if (type.equals(possibility)) {
                    classKey = s;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * If a command is valid, create an instance of that command and return it.
     * If it is a constant, return a constant command instead. If it is invalid, return
     * an error
     * 
     * @param type Command being tested
     * @return Either the type of command requested, or an exception
     */
    public Command buildCommand (String type) {
        if (checkLanguage(type)) {
            try {
                Command newCommand = (Command) Class.forName
                        (myCommandResources.getString(classKey)).newInstance();
                return newCommand;
            }
            catch (InstantiationException e) {
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        else {
            try {
                Double constant = Double.parseDouble(type);
                return new ConstantCommand(type);

            }
            catch (NumberFormatException e2) {
                return null;
            }
        }
        return new NullCommand();

    }

}
