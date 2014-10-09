package commands.operation_commands;

import commands.OperationCommand;


public class SineCommand extends OperationCommand {
    public static final int NUM_CHILDREN = 1;

    public SineCommand () {
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return Math.sin(getMyChildren().get(0).execute());
    }

    @Override
    public String toString () {
        return "sine: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
