package commands;

import java.util.Map;
import backEnd.Model;


public abstract class OperationCommand extends Command {

    public OperationCommand (Map<String, Double> variableMap) {
        super(variableMap);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void initializeCommand (Model m) {
    }

}
