package commands.variable_commands;

import java.util.Map;
import backEnd.Model;
import commands.Command;


/**
 * A for loop command.
 * 
 * Input format: for [ :x 1 110 1 ] [ sum 3 5 ]
 * 
 * @author annamiyajima
 *
 */
public class ForCommand extends Command {

    public static final int NUM_CHILDREN = 2;
    private Map<String, Double> myVarsMap;
    Command myForList;

    public ForCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
        myVarsMap = variableMap;
        myForList = null;
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
