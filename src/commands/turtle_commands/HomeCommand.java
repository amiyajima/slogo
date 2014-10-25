package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Sends a turtle back to the origin
 * @author Ethan Chang
 *
 */
public class HomeCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 0;

    public HomeCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for (Turtle t : turtles) {
            setValue(t.goHome());
        }
    }

    @Override
    public String toString () {
        return "Moved: " + getValue();
    }

}
