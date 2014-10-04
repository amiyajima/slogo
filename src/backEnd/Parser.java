package backEnd;

import java.util.Collection;
import java.util.List;
import commands.Command;
import commands.CommandFactory;

/**
 * A parser that takes in user input and produces a tree containing the nodes
 * and necessary parameters.
 * 
 * The parser is also responsible for throwing an error if the command doesn't
 * exist or doesn't have the proper parameters.
 * 
 * @author Brian Bolze
 * @author Ethan Chang
 * @author Eli Lichtenberg
 * @author Anna Miyajima
 * 
 */
public class Parser {

    private String myString;

    /**
     * Instantiate a parser object
     * 
     */
    public Parser () {

    }

    /**
     * Called by the model via the controller every time a user runs a new
     * script. The Parser will begin by checking the syntax to make sure there
     * are no errors, and will return an integer for different error messages to
     * be handled by the view.
     * 
     * @param script
     *            Raw input from the user
     * @return
     * 
     */
    public int checkScript (String script) {
        return 0;
    }

    /**
     * Called by the model if the input script is valid. At this point, the
     * parser will split the script up into different lines and individual
     * commands. The Parser will then call the CommandFactory to build all of
     * the commands and add them to the returned list
     * 
     * @param script
     *            Raw input from the user (always error free)
     * @return A list of commands to be sent to the ScriptManager
     */
    public List<Command> parseScript (String script) {
        return null;
    }

}
