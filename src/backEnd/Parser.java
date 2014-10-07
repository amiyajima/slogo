package backEnd;

import java.util.Collection;
import java.util.List;
import commands.Command;
import commands.CommandFactory;


class Parser {

    private String myString;

    Parser () {

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
        System.out.println(script);
        String[] inputArray = script.split("\\s+");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i]);
        }

        CommandFactory myFactory = new CommandFactory("English");

        for (String input : inputArray)
        {

        }
        return null;
    }

}
