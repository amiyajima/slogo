package commands.onechild;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;

/**
 * Command to calculate the arctangent of the only child
 * @author Ethan Chang
 *
 */
public class ArcTangentCommand extends OneChildCommand {

    public ArcTangentCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return Math.atan(Math.toRadians(getMyChildren().get(0).execute()));
    }

    @Override
    public String toString () {
        return "atangent: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
