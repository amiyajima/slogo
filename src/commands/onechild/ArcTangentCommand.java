package commands.onechild;

import commands.templates.OneChildCommand;


public class ArcTangentCommand extends OneChildCommand {

    @Override
    public double execute () {
        return Math.atan(Math.toRadians(getMyChildren().get(0).execute()));
    }

    @Override
    public String toString () {
        return "atangent: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
