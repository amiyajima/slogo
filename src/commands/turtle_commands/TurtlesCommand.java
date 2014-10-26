package commands.turtle_commands;

import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Command to return the number of turtles
 * @author ethanchang
 *
 */
public class TurtlesCommand extends TurtleCommand {

    public TurtlesCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        setValue((double)turtleManager.getNumberOfTurtles());
    }

    @Override
    public String toString () {
        return Double.toString(getValue());
    }

}
