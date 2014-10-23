package commands.onechild;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;


public class NotCommand extends OneChildCommand {

    public NotCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() == 0 ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return "and command result: " + execute();
    }

}
