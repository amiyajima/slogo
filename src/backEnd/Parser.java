// CLASS AND CONSTRUCTOR PUBLIC FOR TESTING PURPOSES
package backEnd;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import commands.Command;
import commands.CommandFactory;
import commands.ConstantCommand;


public class Parser {

    private String myString;
    private static final String WHITESPACE = "\\s";
    private String[] inputArray;
    private CommandFactory myFactory;
    private Model myModel;

    public Parser (Model m) {
        myModel = m;
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
    Command parseScript (String script) {
        inputArray = script.split(WHITESPACE);
        myFactory = new CommandFactory("English", myModel);
        LinkedList commandsList = enqueue(inputArray);
        return makeTree(commandsList);
    }

    LinkedList enqueue (String[] input) {
        LinkedList<String> commandQueue = new LinkedList<String>();
        int i = 0;
        while (i < input.length) {
            commandQueue.add(input[i]);
            i++;
        }
        return commandQueue;

    }

    // the list NEEDS to be linked list in order to poll
    public Command makeTree (LinkedList<String> commands) throws RuntimeException {
        // case in which the number of parameters isn't correct
        if (commands.size() < 1) {
            throw new RuntimeException();
        }

        System.out.println("creating command");
        Command c = myFactory.buildCommand(commands.poll());
        if (c instanceof ConstantCommand) { return c; }
        for (int i = 0; i < c.getNumChildren(); i++) {

            c.addChild(makeTree(commands));
        }
        return c;

    }
}
