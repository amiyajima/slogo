package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Command to see if the pen is down
 * @author Ethan Chang
 *
 */
public class PenDownQuery extends TurtleCommand {
    public static final int NUM_CHILDREN = 0;

    public PenDownQuery (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        List<Turtle> turtles = getMyTurtleManager().getTurtleList();
        setValue(turtles.get(turtles.size() - 1).isPenDown() ? 1.0 : 0);
        return getValue();
    }

    @Override
    public String toString () {
        return Double.toString(getValue());
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
    }

}
