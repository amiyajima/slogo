package commands.twochildren;

import backEnd.VariableManager;

import commands.templates.TwoChildCommand;

/**
 * Multiplies it's children together
 * @author Ethan Chang
 *
 */
public class ProductCommand extends TwoChildCommand {

    public ProductCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() * getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "mult: " + getMyChildren().get(0).execute() + " " + getMyChildren().get(1).execute();
    }
}
