package commands.onechild;

import commands.templates.OneChildCommand;


public class NaturalLogCommand extends OneChildCommand {

    @Override
    public double execute () {
        return Math.log(getMyChildren().get(0).execute());
    }

    @Override
    public String toString () {
        return "natural log: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
