package commands.twochildren;

import backEnd.VariableManager;
import commands.templates.TwoChildCommand;


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
