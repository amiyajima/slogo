package commands.operation_commands;

import commands.OperationCommand;


public class RemainderCommand extends OperationCommand {

    public static final int NUM_CHILDREN = 2;

    public RemainderCommand () {
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() % getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "remainder: " + getMyChildren().get(0).execute() + " " + getMyChildren().get(1).execute();
    }

}
