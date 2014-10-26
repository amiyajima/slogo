package commands.twochildren;

import backEnd.VariableManager;

import commands.templates.TwoChildCommand;

/**
 * Command to check of two numbers are equal to 1
 * @author Ethan Chang
 *
 */
public class AndCommand extends TwoChildCommand {

    public AndCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return (getMyChildren().get(0).execute() != 0 && getMyChildren().get(1).execute() != 0) 
                ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return "and command result: " + execute();
    }

}
