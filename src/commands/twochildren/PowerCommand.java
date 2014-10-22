package commands.twochildren;

import commands.templates.TwoChildCommand;


public class PowerCommand extends TwoChildCommand {

    @Override
    public double execute () {
        return Math.pow(getMyChildren().get(0).execute(), getMyChildren().get(1).execute());
    }

    @Override
    public String toString () {
        return "power: " + getMyChildren().get(0).execute() + " to the " +
               getMyChildren().get(1).execute() +
               " = " + execute();
    }
}
