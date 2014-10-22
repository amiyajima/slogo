package commands.onechild;

import commands.templates.OneChildCommand;


public class RandomCommand extends OneChildCommand {

    @Override
    public double execute () {
        return Math.random() * getMyChildren().get(0).execute();
    }

    @Override
    public String toString () {
        return "random # is: " + execute();
    }

}
