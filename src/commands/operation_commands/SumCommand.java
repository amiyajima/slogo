package commands.operation_commands;

import commands.OperationCommand;


public class SumCommand extends OperationCommand {

    public SumCommand () {
        setNumChildren(2);
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() + getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "sum: " + getMyChildren().get(0).execute() + " " + getMyChildren().get(1).execute();
    }

}
