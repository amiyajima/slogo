package commands.twochildren;

import backEnd.VariableManager;
import commands.templates.TwoChildCommand;


public class DifferenceCommand extends TwoChildCommand {

    public DifferenceCommand (VariableManager manager) {
        super(manager);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() - getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "dif: " + getMyChildren().get(0).execute() + " " + getMyChildren().get(1).execute();
    }

}
