package commands.onechild;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;


public class TangentCommand extends OneChildCommand {

    public TangentCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return Math.tan(Math.toRadians(getMyChildren().get(0).execute()));
    }

    @Override
    public String toString () {
        return "tangent: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
