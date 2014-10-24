package commands;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import backEnd.Model;
import backEnd.VariableManager;
import com.sun.xml.internal.fastinfoset.sax.Properties;
import commands.templates.Command;
import commands.templates.TurtleCommand;
import commands.variable_commands.UserInputCommand;
import commands.variable_commands.GlobalVariable;
import commands.variable_commands.Variable;


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
    private VariableManager myVariableManager;

    /**
     * Initializes a command factory
     * 
     * @param language The language commands are being put into the text field
     */
    public CommandFactory (String language, Model model, VariableManager manager) {
        myLanguageResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE
                                                       + "languages/" + language);
        myModel = model;
        myVariableManager = manager;
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

    public boolean isNumeric (String str)
    {
        return str.matches("-?[0-9]+.?[0-9]*");  // match a number with optional '-' and decimal.
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
                    con = newCommandClass.getConstructor(VariableManager.class);
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
                    newCommand = (Command) con.newInstance(myVariableManager);
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
                Command varCommand = new Variable(type, myVariableManager);
                return varCommand;
            }

            if (isNumeric(type)) { return new ConstantCommand(type, myVariableManager); }

        }
        return new UserInputCommand(type, myVariableManager);
    }

}
