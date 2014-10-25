package commands;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;
import commands.templates.Command;
import commands.templates.TurtleCommand;
import commands.variable_commands.Variable;
import exceptions.InvalidInputException;

/**
 * This factory is part of the command pattern implementation. It contains a
 * method called buildCommand which takes in a String type and uses this String
 * to create the type of command requested.
 *
 */
public class CommandFactory {
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    public static final ResourceBundle MYCOMMANDRESOURCES = ResourceBundle
            .getBundle("resources/Commands");
    private ResourceBundle myLanguageResources;
    private String myClassKey;

    /**
     * Initializes a command factory
     *
     * @param language
     *            The language commands are being put into the text field
     */
    public CommandFactory (String language) {
        myLanguageResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "languages/"
                + language);
    }

    /**
     * Searches to see if the command given is can be found in the selected
     * language properties file. If it can, return true, if not false.
     *
     * @param type
     *            command type being checked
     * @return Return true if the command is valid
     */
    private boolean checkLanguage (String type) {
        for (String s : myLanguageResources.keySet()) {
            String[] possibilities = myLanguageResources.getString(s).split(",");
            for (String possibility : possibilities) {
                if (type.equals(possibility)) {
                    myClassKey = s;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVar (String type) {
        return type.startsWith(":");
    }

    public boolean isNumeric (String str) {
        return str.matches("-?[0-9]+.?[0-9]*");
        // match a number with optional '-' and decimal.
    }

    /**
     * PUBLIC FOR TESTING PURPOSES make all letters lower case so input is not
     * case sensative
     *
     * @param type
     * @return
     */
    private String checkCaps (String type) {
        return type.toLowerCase();
    }

    /**
     * If a command is valid, create an instance of that command and return it.
     * If it is a constant, return a constant command instead. If it is invalid,
     * return an error
     *
     * @param type
     *            Command being tested
     * @return Either the type of command requested, or an exception
     */
    public Command buildCommand (String type, TurtleManager turtleManager, VariableManager variableManager) {
        type = checkCaps(type);
        if (checkLanguage(type)) {
            try {
                Class newCommandClass = Class.forName(MYCOMMANDRESOURCES.getString(myClassKey));
                Constructor con = null;
                try {
                    con = newCommandClass.getConstructor(VariableManager.class);
                }
                
                catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                catch (SecurityException e) {
                    e.printStackTrace();
                }
                Command newCommand = null;
                try {
                    newCommand = (Command)con.newInstance(variableManager);
                }
                catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (newCommand instanceof TurtleCommand) {
                    newCommand.initializeCommand(turtleManager);
                }
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
            if (checkVar(type)) {
                Command varCommand = new Variable(type, variableManager);
                return varCommand;
            }

            if (isNumeric(type)) {
                return new ConstantCommand(type, variableManager);
            }
        }
        throw new InvalidInputException("The input '%s' is not a valid input", type);
    }

}
