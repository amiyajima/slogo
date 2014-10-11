package commands.operation_commands;

import java.util.Map;
import commands.Command;
import commands.OperationCommand;


public class CosineCommand extends OperationCommand {

    public static final int NUM_CHILDREN = 1;

    public CosineCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return Math.cos(Math.toRadians(getMyChildren().get(0).execute()));
    }

    @Override
    public String toString () {
        return "cosine: " + getMyChildren().get(0).execute() + " = " + execute();
    }

}
