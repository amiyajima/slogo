package commands.twochildren;

import commands.templates.TwoChildCommand;


public class ProductCommand extends TwoChildCommand {

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() * getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "mult: " + getMyChildren().get(0).execute() + " " + getMyChildren().get(1).execute();
    }
}
