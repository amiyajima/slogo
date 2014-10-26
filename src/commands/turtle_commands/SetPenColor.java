package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Command to set the pen color
 * @author Ethan Chang
 *
 */
public class SetPenColor extends TurtleCommand {
    public static final int NUM_CHILDREN = 1;

    public SetPenColor (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        setValue(getMyChildren().get(0).execute());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for (Turtle turtle : turtles) {
            turtle.getPen().setMyPenColor(getValue());
        }
    }

    @Override
    public String toString () {
        return null;
    }

}
