package commands.variable_commands;

import java.io.IOException;
import backEnd.VariableManager;
import commands.templates.Command;
import commands.templates.TwoChildCommand;


/**
 * A for loop command.
 *
 * Input format: for [ :x 1 10 1 ] [ forward :x ]
 *
 * @author annamiyajima
 *
 */
public class ForCommand extends TwoChildCommand {

    public static final int THIRD_CHILD = 3;
    private Command myForList;

    public ForCommand (VariableManager manager) {
        super(manager);
        myForList = null;
    }

    @Override
    public double execute () {
        double result = 0;
        myForList = getMyChildren().get(0);
        int i = (int)((CommandsList)myForList).getChild(1).execute();
        int upperBound = (int)((CommandsList)myForList).getChild(2).execute();
        int increment = (int)((CommandsList)myForList).getChild(THIRD_CHILD).execute();

        while (i < upperBound) {
            try {
                getVariableManager().addVar(((CommandsList)myForList).getChild(0).toString(),
                                            String.valueOf(i));
            }
            catch (IOException e) {

                e.printStackTrace();
            }
            result += getMyChildren().get(1).execute();
            i += increment;
        }

        return result;
    }

    @Override
    public String toString () {
        return "for " + ((CommandsList)myForList).getChild(0) + " from "
               + ((CommandsList)myForList).getChild(1) + " to "
               + ((CommandsList)myForList).getChild(2) + " incrementing by "
               + ((CommandsList)myForList).getChild(THIRD_CHILD) + " execute "
               + getMyChildren().get(1).toString();
    }
}
