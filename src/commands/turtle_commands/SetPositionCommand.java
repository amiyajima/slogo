package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Command to set the position for a turtle
 * @author ethanchang
 *
 */
public class SetPositionCommand extends TurtleCommand {
    public static final int NUM_CHILDREN = 2;

    public SetPositionCommand (VariableManager manager) {
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
            setValue(t.goTo(getMyChildren().get(0).execute(), getMyChildren().get(1).execute()));
        }
    }

    @Override
    public String toString () {
        return "Moved: " + getValue();
    }

}
