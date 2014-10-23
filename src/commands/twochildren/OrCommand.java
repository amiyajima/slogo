package commands.twochildren;

import backEnd.VariableManager;
import commands.templates.TwoChildCommand;


public class OrCommand extends TwoChildCommand {

    public OrCommand (VariableManager manager) {
        super(manager);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        return (getMyChildren().get(0).execute() != 0 || getMyChildren().get(1).execute() != 0) ? 1.0
                                                                                               : 0.0;
    }

    @Override
    public String toString () {
        return "or command result: " + execute();
    }

}
