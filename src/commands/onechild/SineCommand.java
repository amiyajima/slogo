package commands.onechild;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;

/**
 * Command to get the sine of of the first child's
 * value
 * @author Ethan Chang
 *
 */
public class SineCommand extends OneChildCommand {
    public SineCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return Math.sin(Math.toRadians(getMyChildren().get(0).execute()));
    }

    @Override
    public String toString () {
        return "sine: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
