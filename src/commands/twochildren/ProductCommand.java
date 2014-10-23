package commands.twochildren;

import backEnd.VariableManager;
import commands.templates.TwoChildCommand;


public class ProductCommand extends TwoChildCommand {

    public ProductCommand (VariableManager manager) {
        super(manager);
        // TODO Auto-generated constructor stub
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
