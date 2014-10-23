package backEnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import commands.templates.Command;
import commands.CommandFactory;
import exceptions.SLogoException;


class Parser {

    private CommandFactory myFactory;
    private StringTokenizer myInstructions;
    private Model myModel;
    private Map<String, Command> myCommandMap;
    private VariableManager myVariableManager;

    public static final String CONSTANT_REGEX = "-?[0-9]+\\.?[0-9]*";
    public static final String VARIABLE_REGEX = ":[a-zA-Z]+";
    public static final String COMMAND_REGEX = "[a-zA-Z_]+(\\?)?";
    public static final String OPEN_BRACKET_REGEX = "\\[";
    public static final String CLOSE_BRACKET_REGEX = "\\]";

    Parser (Model model, VariableManager manager) {
        myModel = model;
        myCommandMap = new HashMap<String, Command>();
        myVariableManager = manager;
        myFactory = new CommandFactory("English", myModel, myVariableManager);
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
    List<Command> parseScript (String script) {
        List<Command> myRoots = new ArrayList<Command>();
        myInstructions = new StringTokenizer(script);

        while (myInstructions.hasMoreTokens()) {
            Command createdCommand = makeTree(myInstructions.nextToken());
            myRoots.add(createdCommand);
        }

        return myRoots;
    }

    /**
     * Creates commands from strings and inserts them as children of existing commands
     * Recursive method, returns root of the tree
     * 
     * @param commandName
     * @return
     * @throws RuntimeException
     */
    Command makeTree (String commandName) throws SLogoException {
        System.out.println(commandName);
        Command c = myFactory.buildCommand(commandName);
        if (Pattern.matches(OPEN_BRACKET_REGEX, commandName)) {
            String nextInstruction = myInstructions.nextToken();
            while (!(Pattern.matches(CLOSE_BRACKET_REGEX, nextInstruction))) {
                c.addChild(makeTree(nextInstruction));

                if (!myInstructions.hasMoreElements()) {
                    // throw exception
                    break;
                }

                nextInstruction = myInstructions.nextToken();

            }
            return c;
        }

        else if (Pattern.matches(CONSTANT_REGEX, commandName)) {
            return c;
        }

        else if (Pattern.matches(COMMAND_REGEX, commandName)) {
            while (c.getNumChildrenNeeded() > 0) {
                c.addChild(makeTree(myInstructions.nextToken()));
            }
        }
        else {
            // Throw exception
        }
        return c;
    }
}
