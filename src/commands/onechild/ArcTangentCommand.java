package commands.onechild;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;


public class ArcTangentCommand extends OneChildCommand {

    public ArcTangentCommand (VariableManager manager) {
        super(manager);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        return Math.atan(Math.toRadians(getMyChildren().get(0).execute()));
    }

    @Override
    public String toString () {
        return "atangent: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
