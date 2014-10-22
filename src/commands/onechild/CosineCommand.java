package commands.onechild;

import commands.templates.OneChildCommand;


public class CosineCommand extends OneChildCommand {

    @Override
    public double execute () {
        return Math.cos(Math.toRadians(getMyChildren().get(0).execute()));
    }

    @Override
    public String toString () {
        return "cosine: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
