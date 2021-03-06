package commands.templates;

import backEnd.Model;
import backEnd.VariableManager;

/**
 * Command superclass for commands with two children
 * @author Anna Miyajima
 *
 */
public abstract class TwoChildCommand extends Command {

    public static final int NUM_CHILDREN = 2;

    public TwoChildCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public String toString () {
        return null;
    }

    @Override
    public void initializeCommand (Model model) {
    }

}
