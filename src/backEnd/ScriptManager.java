package backEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import commands.*;


class ScriptManager {

    public ScriptManager () {
    }

    /**
     * Takes in a list of commands and evaluates expressions, expands loops, and
     * breaks it down into atomic TurtleCommands that will be passed to the
     * Turtle to execute
     * 
     * @param commands
     *        List of commands to be evaluated and broken down
     * @return List of executable TurtleCommands to be passed to the Turtle
     */

    public Queue<Command> compileScript (List<Command> roots) {
        for(Command c:roots){
            c.execute(); // just this, if commands doing everything else themselves?
            // not sure how I'll be accessing turtles and variables
        }
       
        /*
         * if turtleCommand
         * TurtleCommand.executeTurtleCommand()
         * else
         * execute()
         */

        return null;

    }

    private void runCommand (Command root) {
        // check typ

        // base case
        if (root.getNumChildren() == 0) {
            // take into account type of command
            root.execute();
        }
        else {
            int numChildren = root.getNumChildren();
            List<Double> arguments = new ArrayList<Double>();
            /*
             * Iterator iter = getChildIterator();
             * while(iter.hasNext) {
             * Command child = iter.getNext();
             * runCommand(child);
             * }
             */
        }
        // else
    }

}
