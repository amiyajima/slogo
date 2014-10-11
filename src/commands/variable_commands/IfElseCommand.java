package commands.variable_commands;

import java.util.Map;
import backEnd.Model;
import commands.Command;


/**
 * 
 * ifelse 5 [ sum 3 5 ] [ forward 50 ]
 * 
 * @author annamiyajima
 *
 */
public class IfElseCommand extends Command {

    public static final int NUM_CHILDREN = 3;

    public IfElseCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        if (getMyChildren().get(0).execute() != 0) {

            return getMyChildren().get(1).execute();
        }
        else {

            return getMyChildren().get(2).execute();
        }
    }

    @Override
    public String toString () {
        return "If " + getMyChildren().get(0).execute() + " != 0, execute " +
               getMyChildren().get(1) + " if " + getMyChildren().get(0).execute() +
               " == 0, execute " + getMyChildren().get(2);
    }

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub

    }

}
