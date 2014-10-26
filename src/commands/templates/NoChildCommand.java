package commands.templates;

import backEnd.Model;
import backEnd.VariableManager;

/**
 * Command superclass for command that don't have children
 * @author Anna Miyajima
 *
 */
public abstract class NoChildCommand extends Command {

    public NoChildCommand (VariableManager manager) {
        super(manager);
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
    public void initializeCommand (Model model) {

    }

}
