package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Command to show a turtle
 * @author Ethan Chang
 *
 */
public class ShowTurtleCommand extends TurtleCommand {
    public static final int SHOW_TURTLE = 1;
    public static final int NUM_CHILDREN = 0;

    public ShowTurtleCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        return SHOW_TURTLE;
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for (Turtle t : turtles) {
            t.toggleVisibility(SHOW_TURTLE);
        }
    }

    @Override
    public String toString () {
        return "Show turtle";
    }

}
