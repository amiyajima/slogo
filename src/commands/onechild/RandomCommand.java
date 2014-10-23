package commands.onechild;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;


public class RandomCommand extends OneChildCommand {

    public RandomCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return Math.random() * getMyChildren().get(0).execute();
    }

    @Override
    public String toString () {
        return "random # is: " + execute();
    }

}
