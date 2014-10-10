package commands.boolean_commands;

import java.util.Map;
import commands.BooleanCommand;
import commands.Command;


public class GreaterThanCommand extends BooleanCommand {

    public static final int NUM_CHILDREN = 2;

    public GreaterThanCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return (getMyChildren().get(0).execute() > getMyChildren().get(1).execute()) ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return "greater than result: " + execute();
    }

}
