package commands.variable_commands;

import java.util.HashMap;
import java.util.Map;
import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.Command;
import commands.templates.TwoChildCommand;


/**
 * A for loop command.
 * 
 * Input format: for [ :x 1 110 1 ] [ sum 3 5 ]
 * 
 * @author annamiyajima
 *
 */
public class ForCommand extends TwoChildCommand {

    private Map<String, Double> myVarsMap;
    Command myForList;

    public ForCommand (VariableManager manager) {
        super(manager);
        myForList = null;
        myVarsMap = new HashMap<String,Double>();
    }

    @Override
    public double execute () {
        double result = 0;
        myForList = getMyChildren().get(0);
        int i = (int) ((CommandsList) myForList).getChild(1).execute();
        int upperBound = (int) ((CommandsList) myForList).getChild(2).execute();
        int increment = (int) ((CommandsList) myForList).getChild(3).execute();

        while (i < upperBound) {
            System.out.println(((CommandsList) myForList).getChild(0).toString());
            myVarsMap.put(((CommandsList) myForList).getChild(0).toString(),
                          (double) i);
            result += getMyChildren().get(1).execute();
            i += increment;
        }

        return result;
    }

    @Override
    public String toString () {
        return "for " + ((CommandsList) myForList).getChild(0) + " from " +
               ((CommandsList) myForList).getChild(1) + " to " +
               ((CommandsList) myForList).getChild(2) +
               " incrementing by " + ((CommandsList) myForList).getChild(3) + " execute " +
               getMyChildren().get(1).toString();
    }

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub

    }

}
