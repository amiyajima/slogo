package commands;

import java.util.Map;
import backEnd.Model;


public class ConstantCommand extends Command {

    private String myValue;
    private Map<String, Double> myVarsMap;

    public ConstantCommand (Map<String, Double> variableMap) {
        this(variableMap, "");
    }

    public ConstantCommand (Map<String, Double> myVariableMap, String value) {
        super(myVariableMap);
        myValue = value;
    }

    @Override
    public double execute () {
        return Double.parseDouble(myValue);
    }

    @Override
    public String toString () {
        return myValue;
    }

    @Override
    public void initializeCommand (Model m) {
    }

}
