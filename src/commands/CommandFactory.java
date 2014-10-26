package commands;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.ResourceBundle;


import main.ResourceFinder;
import backEnd.Model;
import backEnd.VariableManager;

import commands.templates.Command;
import commands.templates.TurtleCommand;
import commands.variable_commands.UserInputCommand;
import commands.variable_commands.Variable;
import exceptions.InvalidInputException;


/**
 * This factory is part of the command pattern implementation. It contains a
 * method called buildCommand which takes in a String type and uses this String
 * to create the type of command requested.
 *
 */
public class CommandFactory {
	
    private String myClassKey;

    public CommandFactory () {
    	
    }

    /**
     * Searches to see if the command given is can be found in the selected
     * language properties file. If it can, return true, if not false.
     *
     * @param type
     *        command type being checked
     * @return Return true if the command is valid
     */
    private boolean checkLanguage (String type) {
    	
    	ResourceBundle languageResources = ResourceFinder.getMyLanguageResources();
    	
        for (String s : languageResources.keySet()) {
            String[] possibilities = languageResources.getString(s).split(",");
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
     * Checks if the command has been previously defined by the user
     * 
     * @param type
     * @return
     */
    private boolean checkUserCommand (String type, Map<String, Command> commandsMap) {
        return commandsMap.containsKey(type);
    }

    /**
     * If a command is valid, create an instance of that command and return it.
     * If it is a constant, return a constant command instead. If it is invalid,
     * return an error
     *
     * @param type
     *        Command being tested
     * @return Either the type of command requested, or an exception
     */
    public Command buildCommand (String type,
                                 Model model,
                                 VariableManager variableManager) {
        Map<String, Command> commandsMap = model.getCommandsMap();
        type = checkCaps(type);
        if (checkLanguage(type)) {
            try {
                Class<?> newCommandClass = Class.forName(ResourceFinder.
                        getMyCommandResources().getString(myClassKey));
                Constructor<?> con = null;
                try {
                    con = newCommandClass.getConstructor(VariableManager.class);
                }
                catch (NoSuchMethodException e) {
                    throw new InvalidInputException("%s is an invalid input", type);
                }
                catch (SecurityException e) {
                    throw new InvalidInputException("%s is an invalid input", type);
                }
                Command newCommand = null;
                try {
                    newCommand = (Command)con.newInstance(variableManager);
                }
                catch (IllegalArgumentException e) {
                    throw new InvalidInputException("%s is an invalid input", type);
                }
                catch (InvocationTargetException e) {
                    throw new InvalidInputException("%s is an invalid input", type);
                }
                if (newCommand instanceof TurtleCommand) {
                    newCommand.initializeCommand(model);
                }
                return newCommand;
            }
            catch (InstantiationException e) {
                throw new InvalidInputException("%s is an invalid input", type);
            }
            catch (IllegalAccessException e) {
                throw new InvalidInputException("%s is an invalid input", type);
            }
            catch (ClassNotFoundException e) {
                throw new InvalidInputException("%s is an invalid input", type);
            }
        }

        else {
            if (checkVar(type)) {
                Command varCommand = new Variable(type, variableManager);
                return varCommand;
            }

            if (isNumeric(type)) { return new ConstantCommand(type, variableManager); }

        }

        if (checkUserCommand(type, commandsMap)) {
            System.out.println("COMMAND EXISTS IN THE MAP: " + commandsMap);
            return commandsMap.get(type);
        }

        return new UserInputCommand(type, variableManager);

    }
}
