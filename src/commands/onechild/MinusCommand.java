package commands.onechild;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;

/**
 * Command to get the negative of the first child
 * @author Ethan Chang
 *
 */
public class MinusCommand extends OneChildCommand {

    public MinusCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return (-getMyChildren().get(0).execute());
    }

    @Override
    public String toString () {
        return "negative: " + getMyChildren().get(0).execute();
    }

}
