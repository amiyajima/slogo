package commands;

import java.util.Map;
import backEnd.Model;

/**
 * Operation commands take two arguments
 * and then perform an operation on them, such as
 * addition, multiplication or division
 * 
 * @author Ethan Chang
 * @author Anna Miyajima
 *
 */
public abstract class OperationCommand extends Command {

    public OperationCommand (Map<String, Double> variableMap) {
        super(variableMap);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void initializeCommand (Model m) {
    }

}
