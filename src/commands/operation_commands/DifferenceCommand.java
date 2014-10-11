package commands.operation_commands;

import java.util.Map;
import commands.Command;
import commands.OperationCommand;


public class DifferenceCommand extends OperationCommand {
    public static final int NUM_CHILDREN = 2;

    public DifferenceCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() - getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "dif: " + getMyChildren().get(0).execute() + " " + getMyChildren().get(1).execute();
    }

}
