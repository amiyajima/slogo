package commands.twochildren;

import backEnd.VariableManager;

import commands.templates.TwoChildCommand;

/**
 * Command to find the sum of two children
 * @author Ethan Chang
 *
 */
public class SumCommand extends TwoChildCommand {

    public SumCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() + getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "sum: " + getMyChildren().get(0).execute() + " " + getMyChildren().get(1).execute();
    }

}
