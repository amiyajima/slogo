package commands.twochildren;

import backEnd.VariableManager;
import commands.templates.TwoChildCommand;


public class RemainderCommand extends TwoChildCommand {

    public RemainderCommand (VariableManager manager) {
        super(manager);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() % getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "remainder: " + getMyChildren().get(0).execute() + " " +
               getMyChildren().get(1).execute();
    }

}
