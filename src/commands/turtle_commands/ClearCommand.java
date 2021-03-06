package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Clear command
 * @author Ethan Chang
 *
 */
public class ClearCommand extends TurtleCommand {

    public ClearCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for (Turtle turtle : turtles) {
            setValue(turtle.goHome());
            turtle.clearMyLines();
            turtle.setOrientation(0.0);
        }
    }

    @Override
    public String toString () {
        return null;
    }

}
