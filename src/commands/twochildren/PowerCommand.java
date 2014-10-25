package commands.twochildren;

import backEnd.VariableManager;

import commands.templates.TwoChildCommand;

/**
 * Raise the first child the the second child's power
 * @author Ethan Chang
 *
 */
public class PowerCommand extends TwoChildCommand {

    public PowerCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return Math.pow(getMyChildren().get(0).execute(), getMyChildren().get(1).execute());
    }

    @Override
    public String toString () {
        return "power: " + getMyChildren().get(0).execute() + " to the "
                + getMyChildren().get(1).execute() + " = " + execute();
    }
}
