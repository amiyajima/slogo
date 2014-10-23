package backEnd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import commands.CommandFactory;
import commands.ConstantCommand;
import commands.templates.Command;
import commands.variable_commands.CommandsList;

class Parser {

    private String myString;
    private CommandFactory myFactory;
    private StringTokenizer myInstructions;
    private Model myModel;
    private Map<String, Command> myCommandMap;
    private VariableManager myVariableManager;

    Parser (Model model, VariableManager manager) {
        myModel = model;
        myCommandMap = new HashMap<String, Command>();
        myVariableManager = manager;
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
        myFactory = new CommandFactory("English", myModel, myVariableManager);
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
    Command makeTree (String commandName) throws RuntimeException {
        System.out.println(commandName);
        Command c = myFactory.buildCommand(commandName);
        if (c instanceof CommandsList) {
            String nextInstruction = myInstructions.nextToken();
            while (!(nextInstruction.equals("]"))) {
                System.out.println("CREATING NEW LIST CHILD");
                c.addChild(makeTree(nextInstruction));
                nextInstruction = myInstructions.nextToken();
            }
            return c;
        }

        if (c instanceof ConstantCommand) { return c; }
        while (c.getNumChildrenNeeded() > 0) {
            c.addChild(makeTree(myInstructions.nextToken()));
        }
        return c;
    }
}
