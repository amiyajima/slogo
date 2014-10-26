package commands.twochildren;

import backEnd.VariableManager;

import commands.templates.TwoChildCommand;

/**
 * Command to find the remainder from dividing the first number
 * by the second
 * @author Ethan Chang
 *
 */
public class RemainderCommand extends TwoChildCommand {

    public RemainderCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() % getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "remainder: " + getMyChildren().get(0).execute() + " "
                + getMyChildren().get(1).execute();
    }

}
