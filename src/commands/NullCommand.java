package commands;

import java.util.Map;
import backEnd.Model;

/**
 * NullCommand. NullCommand which is used instead of a 
 * null.
 * 
 * @author Anna Miyajima
 *
 */
public class NullCommand extends Command {

    public NullCommand (Map<String, Double> myVariableMap) {
        super(myVariableMap);
    }

    @Override
    public double execute () {
        return 0.0;
    }

    @Override
    public String toString () {
        return null;
    }

    @Override
    public void initializeCommand (Model m) {
    }

    public int getNumChildrenNeeded () {
        return 0;
    }

}
