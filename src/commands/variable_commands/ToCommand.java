package commands.variable_commands;

import backEnd.VariableManager;
import commands.templates.OneChildCommand;
import exceptions.SLogoException;


public class ToCommand extends OneChildCommand {

    public ToCommand (VariableManager manager) {
        super(manager);
        // TODO Auto-generated constructor stub
    }

    public double execute () {
        System.out.println("execute called on to");

        if (getMyChildren().get(0) instanceof UserInputCommand) {
            System.out.println("execute called on user input command");
            getMyChildren().get(0).execute();
        }
        else {
            throw new SLogoException("cannot create command -- enter in correct format");
        }
        return 0.0;
    }

}
