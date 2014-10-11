package commands.boolean_commands;

import java.util.Map;
import commands.BooleanCommand;
import commands.Command;


public class NotCommand extends BooleanCommand {
    public static final int NUM_CHILDREN = 1;

    public NotCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() == 0 ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return "and command result: " + execute();
    }

}
