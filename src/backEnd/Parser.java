package backEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import commands.CommandFactory;
import commands.templates.Command;
import commands.variable_commands.ToCommand;

import exceptions.InvalidInputException;


/**
 * Parser for slogo. If given a string of commands, the parser will
 * split it into tokens and convert them into a list of roots for runnable
 * trees.
 * 
 * @author Ethan Chang
 * @author Anna Miyajima
 *
 */
public class Parser {

    public static final String CONSTANT_REGEX = "-?[0-9]+\\.?[0-9]*";
    public static final String VARIABLE_REGEX = ":[a-zA-Z]+";
    public static final String COMMAND_REGEX = "[a-zA-Z_]+(\\?)?";
    public static final String OPEN_BRACKET_REGEX = "\\[";
    public static final String CLOSE_BRACKET_REGEX = "\\]";

    private CommandFactory myFactory;
    private StringTokenizer myInstructions;
    private VariableManager myVariableManager;

    /**
     * Constructor for the parser
     */

    public Parser (CommandFactory commandFactory) {
        myFactory = commandFactory;
    }

    /**
     * Called by the model if the input script is valid. At this point, the
     * parser will split the script up into different lines and individual
     * commands. The Parser will then call the CommandFactory to build all of
     * the commands and add them to the returned list
     *
     * @param script
     *        Raw input from the user (always error free)
     * @return A list of commands to be sent to the ScriptManager
     */

    List<Command> parseScript (String script, Model model, VariableManager variableManager) {

        Map<String, Command> commandsMap = model.getCommandsMap();
        
        List<Command> myRoots = new ArrayList<Command>();
        myInstructions = new StringTokenizer(script);
        
        while (myInstructions.hasMoreTokens()) {
            Command createdCommand =
                    makeTree(myInstructions.nextToken(), model, variableManager);
            if (createdCommand instanceof ToCommand) {
                Command nextToAdd = new ToCommand(myVariableManager, (ToCommand) createdCommand);
                commandsMap.put(nextToAdd.toString(), nextToAdd);
            }

            myRoots.add(createdCommand);
        }
        return myRoots;
    }

    /**
     * Creates commands from strings and inserts them as children of existing
     * commands Recursive method, returns root of the tree
     *
     * @param commandName
     * @return
     * @throws RuntimeException
     */

    public Command makeTree (String commandName, Model model, VariableManager variableManager) {
        System.out.println(commandName);
        Command c = myFactory.buildCommand(commandName, model, variableManager);
        if (Pattern.matches(OPEN_BRACKET_REGEX, commandName)) {
            String nextInstruction = myInstructions.nextToken();
            while (!(Pattern.matches(CLOSE_BRACKET_REGEX, nextInstruction))) {
                c.addChild(makeTree(nextInstruction, model, variableManager));
                if (!myInstructions.hasMoreElements()) { throw new InvalidInputException("Open brackets must have a corresponding ']'"); }
                nextInstruction = myInstructions.nextToken();
            }
            return c;
        }
        else if (Pattern.matches(CONSTANT_REGEX, commandName) ||
                 Pattern.matches(VARIABLE_REGEX, commandName)) {
            return c;
        }
        else if (Pattern.matches(COMMAND_REGEX, commandName)) {

            while (c.getNumChildrenNeeded() > 0) {
                c.addChild(makeTree(myInstructions.nextToken(), model, variableManager));
            }
        }
        else {
            throw new InvalidInputException("error in parser");
        }
        return c;
    }
}
