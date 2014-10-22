package commands.onechild;

import commands.templates.OneChildCommand;


public class SineCommand extends OneChildCommand {
    @Override
    public double execute () {
        return Math.sin(Math.toRadians(getMyChildren().get(0).execute()));
    }

    @Override
    public String toString () {
        return "sine: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
