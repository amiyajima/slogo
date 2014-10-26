package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Hides a turtle
 * @author Ethan Chang
 *
 */
public class HideTurtleCommand extends TurtleCommand {
    public static final int HIDE_TURTLE = 0;
    public static final int NUM_CHILDREN = 0;

    public HideTurtleCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        return HIDE_TURTLE;
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for (Turtle t : turtles) {
            t.toggleVisibility(HIDE_TURTLE);
        }
    }

    @Override
    public String toString () {
        return "Hide turtle";
    }

}
