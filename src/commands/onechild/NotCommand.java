package commands.onechild;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;

/**
 * Command to get the 1 if 0 and 0 if 1
 * @author Ethan Chang
 *
 */
public class NotCommand extends OneChildCommand {

    public NotCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() == 0 ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return "and command result: " + execute();
    }

}
