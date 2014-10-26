package commands.onechild;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;

/**
 * Command to get a random number between 0 and the
 * value of the first child.
 * @author Ethan Chang
 *
 */
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
