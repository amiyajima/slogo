package commands.variable_commands;

import java.util.Map;
import commands.Command;
import commands.VariableCommand;


public class MakeCommand extends VariableCommand {

    public static final int NUM_CHILDREN = 2;
    private Map<String, Double> myVarsMap;

    public MakeCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
        myVarsMap = variableMap;
    }

    @Override
    public double execute () {
        myVarsMap.put(getMyChildren().get(0).toString(), getMyChildren().get(1).execute());
        return getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "create var " + getMyChildren().get(0).toString() + " = " +
               getMyChildren().get(1);
    }
}
