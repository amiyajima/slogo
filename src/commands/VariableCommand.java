package commands;

import java.util.Map;
import backEnd.Model;


public class VariableCommand extends Command {

    public VariableCommand (Map<String, Double> variableMap) {
        super(variableMap);
    }

    @Override
    public double execute () {
        // TODO Auto-generated method stub
        return 0.0;
    }

    @Override
    public String toString () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub

    }

}
