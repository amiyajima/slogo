package commands;

import backEnd.Model;
import backEnd.VariableManager;
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
    public void initializeCommand (Model model) {
    }

    @Override
    public int getNumChildrenNeeded () {
        return 0;
    }

}
