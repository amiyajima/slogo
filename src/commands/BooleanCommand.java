package commands;

import java.util.Map;
import backEnd.Model;


/**
 * Boolean commands. Boolean commands all return either 1 or 0 based
 * on certain parameters. They do not need to initialize anything by
 * using the model
 * 
 * @author Ethan Chang
 *
 */
public abstract class BooleanCommand extends Command {

    public BooleanCommand (Map<String, Double> variableMap) {
        super(variableMap);
    }

    @Override
    public void initializeCommand (Model m) {
    }

}
