package commands.operation_commands;

import java.util.Map;
import commands.Command;
import commands.OperationCommand;


public class ArcTangentCommand extends OperationCommand {
    public static final int NUM_CHILDREN = 1;

    public ArcTangentCommand (Map<String, Double> variableMap) {
        super(variableMap);
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
