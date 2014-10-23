package commands.twochildren;

import backEnd.VariableManager;
import commands.templates.TwoChildCommand;


public class NotEqualCommand extends TwoChildCommand {

    public NotEqualCommand (VariableManager manager) {
        super(manager);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        return (getMyChildren().get(0).execute() != getMyChildren().get(1).execute()) ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return "not equal to result: " + execute();
    }

}
