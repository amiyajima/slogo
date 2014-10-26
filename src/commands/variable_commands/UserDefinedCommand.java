package commands.variable_commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.Command;

public class UserDefinedCommand extends Command {

    public static final int NUM_CHILDREN = 1;
    private List<String> myVariables;
    private VariableManager myVariableManager;
    private Map<String, String> myLocalVariables;
    private Command myCommandsToExecute;
    
    public UserDefinedCommand(VariableManager manager, UserInputCommand premadeCommand){
        super(manager);
        System.out.println("userdefinedcommand created with list " + premadeCommand);
        myVariables = premadeCommand.getParameterList();
        myVariableManager = getVariableManager();
        myLocalVariables = new HashMap<String,String>();
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("executing commands in userdefinedcommand");
        getMyChildren().get(1).execute();
        try {
            myVariableManager.popVarProperties();
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    private void mapVariables () {
        CommandsList myVariableValues = (CommandsList) getMyChildren().get(0);
        for(int i = 0; i<myVariables.size(); i++){
            myLocalVariables.put(myVariables.get(i),myVariableValues.getChild(i).toString());
        }
        System.out.println("mapVariables completed in userdefinedcommand. myvariables are " + myLocalVariables);
    }

    @Override
    public String toString () {
        return "userdefinedcommand tostring";
    }

    @Override
    public void initializeCommand (Model model) {
        // TODO Auto-generated method stub

    }

}
