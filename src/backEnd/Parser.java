package backEnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import commands.CommandFactory;
import commands.templates.Command;
import exceptions.InvalidInputException;
import exceptions.SLogoException;


class Parser {

    public static final String CONSTANT_REGEX = "-?[0-9]+\\.?[0-9]*";
    public static final String VARIABLE_REGEX = ":[a-zA-Z]+";
    public static final String COMMAND_REGEX = "[a-zA-Z_]+(\\?)?";
    public static final String OPEN_BRACKET_REGEX = "\\[";
    public static final String CLOSE_BRACKET_REGEX = "\\]";

    private CommandFactory myFactory;
    private StringTokenizer myInstructions;
    private Model myModel;
    private VariableManager myVariableManager;

    Parser (Model model, VariableManager manager) {
        myModel = model;
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
            System.out.println(myRoots);
        }
        System.out.println("parse script completed");
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
    Command makeTree (String commandName) throws SLogoException {
        System.out.println(commandName);
        Command c = myFactory.buildCommand(commandName);
        System.out.println(c);
        if (Pattern.matches(OPEN_BRACKET_REGEX, commandName)) {
            String nextInstruction = myInstructions.nextToken();
            System.out.println("new bracket opened");
            while (!(Pattern.matches(CLOSE_BRACKET_REGEX, nextInstruction))) {
                c.addChild(makeTree(nextInstruction));

                if (!myInstructions.hasMoreElements()) { throw new InvalidInputException(
                                                                                         "Open brackets must have a corresponding ']'"); }

                nextInstruction = myInstructions.nextToken();

            }
            System.out.println("bracket closed");
            return c;
        }

        else if (Pattern.matches(CONSTANT_REGEX, commandName)) {
            return c;
        }

        else if (Pattern.matches(COMMAND_REGEX, commandName)) {
            System.out.println("command identified");
            while (c.getNumChildrenNeeded() > 0) {
                System.out.println(c + " needs " + c.getNumChildrenNeeded() + " more children.");
                c.addChild(makeTree(myInstructions.nextToken()));
            }
        }
        else {
            throw new InvalidInputException("");
        }
        return c;
    }
}
