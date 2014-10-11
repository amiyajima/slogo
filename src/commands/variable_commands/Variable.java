package commands.variable_commands;

import java.util.ArrayList;
import java.util.Map;
import backEnd.Model;
import commands.Command;


public class Variable extends Command {
    private String myValue;
    private Map<String, Double> myVarsMap;

    public Variable (Map<String, Double> variableMap) {
        this(variableMap, "");
    }

    public Variable (Map<String, Double> myVariableMap, String value) {
        super(myVariableMap);
        myValue = value;
        myVarsMap = myVariableMap;
    }

    @Override
    public double execute () {
        return myVarsMap.get(myValue);
    }

    @Override
    public String toString () {
        return myValue;
    }

    @Override
    public void initializeCommand (Model m) {
    }

}
