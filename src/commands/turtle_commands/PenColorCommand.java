package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 *Command to set the color of the pen
 * @author Ethan Chang
 *
 */
public class PenColorCommand extends TurtleCommand {
    public static final int NUM_CHILDREN = 0;

    public PenColorCommand (VariableManager manager) {
        super(manager);
        setNumChildren(0);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtleList = turtleManager.getTurtleList();
        setValue(turtleList.get(turtleList.size() - 1).getPen().getMyPenColor());
    }

    @Override
    public String toString () {
        return null;
    }

}
