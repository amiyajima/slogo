package commands.operation_commands;

import commands.OperationCommand;


public class RandomCommand extends OperationCommand {
    public static final int NUM_CHILDREN = 1;

    public RandomCommand () {
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return Math.random() * getMyChildren().get(0).execute();
    }

    @Override
    public String toString () {
        return "random # is: " + execute();
    }

}
