package commands.twochildren;

import java.util.Map;
import backEnd.VariableManager;
import commands.templates.Command;
import commands.templates.TwoChildCommand;


public class QuotientCommand extends TwoChildCommand {

    public QuotientCommand (VariableManager manager) {
        super(manager);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() / getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "dif: " + getMyChildren().get(0).execute() + " " + getMyChildren().get(1).execute();
    }

}
