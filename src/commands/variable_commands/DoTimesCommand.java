package commands.variable_commands;

import java.util.Map;
import backEnd.Model;
import commands.Command;


/**
 * A do times command, that runs a set of commands using variable values from 1 to limit
 * 
 * Input format:  dotimes [ :k 5 ] [ sum :k 1 ]
 * 
 * @author annamiyajima
 *
 */
public class DoTimesCommand extends Command {

    public static final int NUM_CHILDREN = 2;
    private Map<String, Double> myVarsMap;
    Command myVariable;

    public DoTimesCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
        myVarsMap = variableMap;
        myVariable = null;
    }

    @Override
    public double execute () {
        Double result = 0.0;
        myVariable = getMyChildren().get(0);
        for (int i = (int) ((CommandsList) myVariable).getChild(1).execute(); i > 0; i--) {
            // for each value the var up to limit
            System.out.println(((CommandsList) myVariable).getChild(0).toString());
            myVarsMap.put(((CommandsList) myVariable).getChild(0).toString(),
                          (double) i);
            getMyChildren().get(1).execute();
            System.out.println(myVarsMap);
        }
        return result;
    }

    @Override
    public String toString () {
        return "do " + getMyChildren().get(1).toString() + " " +
               " incrementing " + ((CommandsList) myVariable).getChild(0).toString() +
               " from 1 to " + (int) ((CommandsList) myVariable).getChild(1).execute();
    }

    @Override
    public void initializeCommand (Model m) {

    }

}
