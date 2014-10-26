package commands.variable_commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.Command;


/**
 * This User Defined command is created when a previously defined user command is called
 * This command takes in variable parameters and uses these in running commands copied in from the
 * corresponding user input command
 * 
 * @author annamiyajima
 *
 */
public class UserDefinedCommand extends Command {

    public static final int NUM_CHILDREN = 1;
    private List<String> myVariables;
    private VariableManager myVariableManager;
    private Map<String, String> myLocalVariables;
    private Command myCommandsToExecute;

    public UserDefinedCommand (VariableManager manager, UserInputCommand premadeCommand) {
        super(manager);
        myVariables = premadeCommand.getParameterList();
        myVariableManager = getVariableManager();
        myLocalVariables = new HashMap<String, String>();
        myCommandsToExecute = premadeCommand.getMyChildren().get(1);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        mapVariables();
        addChild(myCommandsToExecute);
        System.out.println("added branch, my children are now " + getMyChildren());
        try {
            myVariableManager.pushVarProperties(myLocalVariables);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        getMyChildren().get(1).execute();
        try {
            myVariableManager.popVarProperties();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void mapVariables () {
        CommandsList myVariableValues = (CommandsList)getMyChildren().get(0);
        for (int i = 0; i < myVariables.size(); i++) {
            myLocalVariables.put(myVariables.get(i), myVariableValues.getChild(i).toString());
        }
    }

    @Override
    public String toString () {
        return "userdefinedcommand tostring";
    }

    @Override
    public void initializeCommand (Model model) {
    }

}
