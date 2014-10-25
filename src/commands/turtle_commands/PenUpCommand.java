package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Raises the pen
 * @author Ethan Chang
 *
 */
public class PenUpCommand extends TurtleCommand {
    public static final int PEN_UP = 0;
    public static final int NUM_CHILDREN = 0;

    public PenUpCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        return PEN_UP;
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for (Turtle t : turtles) {
            t.togglePen(PEN_UP);
        }
    }

    @Override
    public String toString () {
        return "Pen up";
    }

}
