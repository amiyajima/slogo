package commands.onechild;

import commands.templates.OneChildCommand;


public class TangentCommand extends OneChildCommand {

    @Override
    public double execute () {
        return Math.tan(Math.toRadians(getMyChildren().get(0).execute()));
    }

    @Override
    public String toString () {
        return "tangent: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
