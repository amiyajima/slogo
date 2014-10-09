package commands.operation_commands;

import commands.OperationCommand;

public class ArcTangentCommand extends OperationCommand {
    public static final int NUM_CHILDREN = 1;

    public ArcTangentCommand () {
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return Math.atan(Math.toRadians(getMyChildren().get(0).execute()));
    }

    @Override
    public String toString () {
        return "atangent: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
