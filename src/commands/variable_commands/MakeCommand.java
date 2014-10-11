package commands.variable_commands;

import java.util.Map;
import backEnd.Model;
import commands.Command;


public class MakeCommand extends Command {

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

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub

    }
}
