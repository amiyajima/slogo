package commands.twochildren;

import backEnd.VariableManager;

import commands.templates.TwoChildCommand;

/**
 * Command to check if the first child is greater than the second
 * @author Ethan Chang
 *
 */
public class GreaterThanCommand extends TwoChildCommand {

    public GreaterThanCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return (getMyChildren().get(0).execute() > getMyChildren().get(1).execute()) ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return "greater than result: " + execute();
    }

}
