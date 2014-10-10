package commands.turtle_commands;

import java.util.Map;
import backEnd.AbstractTurtle;
import commands.Command;
import commands.TurtleCommand;


public class ShowTurtleCommand extends TurtleCommand {
    public static final int SHOW_TURTLE = 1;
    public static final int NUM_CHILDREN = 0;

    public ShowTurtleCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle());
        return SHOW_TURTLE;
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        t.toggleVisibility(SHOW_TURTLE);
    }

    @Override
    public String toString () {
        return "Show turtle";
    }

}
