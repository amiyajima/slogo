package commands.variable_commands;

import java.util.HashMap;
import java.util.Map;
import backEnd.Model;
import commands.templates.Command;
import commands.templates.TwoChildCommand;


/**
 * A do times command, that runs a set of commands using variable values from 1 to limit
 * 
 * Input format: dotimes [ :k 5 ] [ sum :k 1 ]
 * 
 * @author annamiyajima
 *
 */
public class DoTimesCommand extends TwoChildCommand {
    private Map<String, Double> myVarsMap;
    private Command myVariable;

    public DoTimesCommand () {
        myVariable = null;
        myVarsMap = new HashMap<String, Double>();
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
