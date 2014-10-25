package commands;

import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;

import commands.templates.Command;

/**
 * NullCommand. NullCommand which is used instead of a null.
 *
 * @author Anna Miyajima
 *
 */
public class NullCommand extends Command {

    public NullCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return 0.0;
    }

    @Override
    public String toString () {
        return null;
    }

    @Override
    public void initializeCommand (TurtleManager turtleManager) {
    }

    @Override
    public int getNumChildrenNeeded () {
        return 0;
    }

}
