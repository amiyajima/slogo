package commands.operation_commands;

import java.util.Map;
import commands.Command;
import commands.OperationCommand;


public class PowerCommand extends OperationCommand {
    public static final int NUM_CHILDREN = 2;

    public PowerCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return Math.pow(getMyChildren().get(0).execute(), getMyChildren().get(1).execute());
    }

    @Override
    public String toString () {
        return "power: " + getMyChildren().get(0).execute() + " to the " +
               getMyChildren().get(1).execute() +
               " = " + execute();
    }
}
