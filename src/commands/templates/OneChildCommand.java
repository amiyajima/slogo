package commands.templates;

import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;

/**
 * Command superclass for commands with one child
 * @author Anna Miyajima
 *
 */
public abstract class OneChildCommand extends Command {

    public static final int NUM_CHILDREN = 1;

    public OneChildCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return 0;
    }

    @Override
    public String toString () {
        return null;
    }

    @Override
    public void initializeCommand (TurtleManager turtleManager) {
    }

}
