package commands;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import commands.templates.Command;
import commands.templates.TurtleCommand;
import commands.variable_commands.UserInputCommand;
import commands.variable_commands.Variable;
import backEnd.Model;


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
    private Model myModel;

    /**
     * Initializes a command factory
     * 
     * @param language The language commands are being put into the text field
     */
    public CommandFactory (String language, Model model) {
        myLanguageResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE
                                                       + "languages/" + language);
        myModel = model;
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

    private boolean checkVar (String type) {
        if (type.startsWith(":")) {
            return true;
        }
        else return false;
    }

    /**
     * PUBLIC FOR TESTING PURPOSES
     * make all letters lower case so input is not case sensative
     * 
     * @param type
     * @return
     */
    private String checkCaps (String type) {
        return type.toLowerCase();
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
        type = checkCaps(type);
        if (checkLanguage(type)) {
            try {
                Class newCommandClass = Class.forName
                        (myCommandResources.getString(classKey));
                Constructor con = null;
                try {
                    con = newCommandClass.getConstructor();
                }
                catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Command newCommand = null;
                try {
                    newCommand = (Command) con.newInstance();
                }
                catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (newCommand instanceof TurtleCommand) {
                    newCommand.initializeCommand(myModel);
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
                Command varCommand = new Variable(type);
                return varCommand;
            }
            try {
                Double.parseDouble(type);
                return new ConstantCommand(type);

            }
            catch (NumberFormatException e2) {
                return new NullCommand();
            }
        }
        return new UserInputCommand(type);

    }
}
