package commands.twochildren;

import commands.templates.TwoChildCommand;


public class GreaterThanCommand extends TwoChildCommand {

    @Override
    public double execute () {
        return (getMyChildren().get(0).execute() > getMyChildren().get(1).execute()) ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return "greater than result: " + execute();
    }

}
