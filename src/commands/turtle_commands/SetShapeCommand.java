package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Command to set which shape is being used
 * @author Ethan Chang
 *
 */
public class SetShapeCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 1;

    public SetShapeCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        setValue(getMyChildren().get(0).execute());
        executeTurtleCommand(getMyTurtleManager());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for (Turtle turtle : turtles) {
            turtle.setShapeIndex(getValue());
        }

    }

    @Override
    public String toString () {
        return null;
    }

}
