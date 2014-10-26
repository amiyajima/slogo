package commands.variable_commands;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;
import exceptions.SLogoException;


public class ToCommand extends OneChildCommand {

    public ToCommand (VariableManager manager) {
        super(manager);
    }

    public ToCommand (VariableManager manager, ToCommand original) {
        this(manager);
        this.addChild(original.getMyChildren().get(0));
    }

    public double execute () {
        if (getMyChildren().get(0) instanceof UserInputCommand) {
            getMyChildren().get(0).execute();
        }

        else {
            throw new SLogoException("cannot create command -- enter in correct format");
        }
        return 0.0;
    }

    @Override
    public String toString () {
        return getMyChildren().get(0).toString();

    }

}
