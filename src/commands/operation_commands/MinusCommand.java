package commands.operation_commands;

import java.util.Map;
import commands.Command;
import commands.OperationCommand;


public class MinusCommand extends OperationCommand {

    public static final int NUM_CHILDREN = 1;

    public MinusCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return (-getMyChildren().get(0).execute());
    }

    @Override
    public String toString () {
        return "negative: " + getMyChildren().get(0).execute();
    }

}
