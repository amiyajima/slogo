package commands.twochildren;

import backEnd.VariableManager;

import commands.templates.TwoChildCommand;

/**
 * Command to check if two numbers are equal
 * @author Ethan Chang
 *
 */
public class EqualCommand extends TwoChildCommand {

    public EqualCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return (getMyChildren().get(0).execute() == getMyChildren().get(1).execute()) ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return "equal to result: " + execute();
    }

}
