package commands.operation_commands;

import commands.OperationCommand;


public class TangentCommand extends OperationCommand {

    public static final int NUM_CHILDREN = 1;

    public TangentCommand () {
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return Math.tan(getMyChildren().get(0).execute());
    }

    @Override
    public String toString () {
        return "tangent: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
