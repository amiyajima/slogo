package commands.variable_commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.Command;
import commands.templates.TwoChildCommand;


/**
 * A do times command, that runs a set of commands using variable values from 1 to limit
 * 
 * Input format: dotimes [ :k 5 ] [ fd :k ]
 * 
 * @author annamiyajima
 *
 */
public class DoTimesCommand extends TwoChildCommand {
    private Command myVariable;
    private Map<String, String> myLocalVariables;

    public DoTimesCommand (VariableManager manager) {
        super(manager);
        myVariable = null;
        myLocalVariables = new HashMap<String, String>();
    }

    @Override
    public double execute () {
        Double result = 0.0;
        myVariable = getMyChildren().get(0);
        VariableManager variablemanager = getVariableManager();
        for (int i = 1; i <= (int) ((CommandsList) myVariable).getChild(1).execute(); i++) {
            // for each value the var up to limit
            // replace all instances of
            myLocalVariables.put(((CommandsList) myVariable).getChild(0).toString(),
                                 String.valueOf(i));
            try {
                variablemanager.pushVarProperties(myLocalVariables);
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            getMyChildren().get(1).execute();
            try {
                variablemanager.popVarProperties();
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
