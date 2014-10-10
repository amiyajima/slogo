package commands.operation_commands;

import java.util.Map;
import commands.Command;
import commands.OperationCommand;


public class NaturalLogCommand extends OperationCommand {
    public static final int NUM_CHILDREN = 1;

    public NaturalLogCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return Math.log(getMyChildren().get(0).execute());
    }

    @Override
    public String toString () {
        return "natural log: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
