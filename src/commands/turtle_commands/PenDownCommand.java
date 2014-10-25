package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Command to put the pen down
 * @author Ethan Chang
 *
 */
public class PenDownCommand extends TurtleCommand {
    public static final int PEN_DOWN = 1;
    public static final int NUM_CHILDREN = 0;

    public PenDownCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        return PEN_DOWN;
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for (Turtle t : turtles) {
            t.togglePen(PEN_DOWN);
        }
    }

    @Override
    public String toString () {
        return "Pen down";
    }

}
