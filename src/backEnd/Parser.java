package backEnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import commands.Command;
import commands.CommandFactory;
import commands.ConstantCommand;
import commands.variable_commands.MakeCommand;
import commands.variable_commands.Variable;
import exceptions.*;


// contain hashmap for variables, replace mapped value for variable

class Parser {

    private String myString;
    private CommandFactory myFactory;
    private StringTokenizer myCommands;
    private Map<String, Command> myVarsMap;
    private Model myModel;

    Parser (Model model) {
        myModel = model;
        myVarsMap = new HashMap<String, Command>();
    }

    /**
     * Called by the model via the controller every time a user runs a new
     * script. The Parser will begin by checking the syntax to make sure there
     * are no errors, and will return an integer for different error messages to
     * be handled by the view.
     * 
     * @param script
     *        Raw input from the user
     * @return
     * 
     */
    int checkScript (String script) {
        /*
         * try{
         * 
         * }
         * catch(){
         * 
         * }
         */
        return 0;
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
        myFactory = new CommandFactory("English", myModel);
        myCommands = new StringTokenizer(script);

        while (myCommands.hasMoreTokens()) {
            Command createdCommand = makeTree(myCommands.nextToken());
            myRoots.add(createdCommand);
            System.out.println(myRoots);
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
        if (myVarsMap.keySet().contains(commandName)) {
            System.out.println("variable recognized");
            return myVarsMap.get(commandName);
        }
        System.out.println(commandName);
        Command c = myFactory.buildCommand(commandName);
        if (c instanceof ConstantCommand) { return c; }
        if (c instanceof Variable) {
            myVarsMap.put(commandName, c);
            c.addChild(makeTree(myCommands.nextToken()));
            System.out.println("vars map " + myVarsMap);
        }
        while (c.getNumChildrenNeeded() > 0) {
            c.addChild(makeTree(myCommands.nextToken()));
        }
        return c;
    }
}
