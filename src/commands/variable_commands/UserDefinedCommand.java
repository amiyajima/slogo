package commands.variable_commands;

import java.util.List;
import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.Command;

public class UserDefinedCommand extends Command {

    public static final int NUM_CHILDREN = 2;
    private List<String> myVariables;
    private VariableManager myVariableManager;
    
    public UserDefinedCommand(VariableManager manager, List<String> list){
        super(manager);
        System.out.println("userdefinedcommand created with list " + list);
        myVariables = list;
        myVariableManager = getVariableManager();
        setNumChildren(NUM_CHILDREN);
    }
    
    @Override
    public double execute () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString () {
        // TODO Auto-generated method stub
        return "userdefinedcommand tostring";
    }

    @Override
    public void initializeCommand (Model model) {
        // TODO Auto-generated method stub

    }

}
