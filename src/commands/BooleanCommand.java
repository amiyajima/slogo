package commands;

import java.util.Map;
import backEnd.Model;


public abstract class BooleanCommand extends Command {

    public BooleanCommand (Map<String, Double> variableMap) {
        super(variableMap);
    }

    @Override
    public void initializeCommand (Model m) {
    }

}
