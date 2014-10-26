package commands.onechild;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;

/**
 *Command to calculate the cosine of the first child
 * @author Ethan Chang
 *
 */
public class CosineCommand extends OneChildCommand {

    public CosineCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return Math.cos(Math.toRadians(getMyChildren().get(0).execute()));
    }

    @Override
    public String toString () {
        return "cosine: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
