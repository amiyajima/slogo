package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Command to turn the turtle left
 * @author Ethan Chang
 *
 */
public class LeftCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 1;

    public LeftCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        double value = getMyChildren().get(0).execute();
        setValue(value);
        executeTurtleCommand(getMyTurtleManager());
        return value;
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for (Turtle t : turtles) {
            t.turnTurtle(-getValue());
        }
    }

    @Override
    public String toString () {
        return "Left: " + getMyChildren().get(0).execute();
    }

}
