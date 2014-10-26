package commands.onechild;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;

/**
 * Command to get the natural log of the first child's value
 * @author Ethan Chang
 *
 */
public class NaturalLogCommand extends OneChildCommand {

    public NaturalLogCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return Math.log(getMyChildren().get(0).execute());
    }

    @Override
    public String toString () {
        return "natural log: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
