package commands.variable_commands;

import java.util.ArrayList;
import java.util.List;
import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.Command;


/**
 * Defines user created command
 *
 * TO newcommand [ :k :x ] [ sum :k 5 forward :x ]
 *
 * @author annamiyajima
 *
 */
public class UserInputCommand extends Command {

    public static final int NUM_CHILDREN = 2;
    private String myName;
    private List<String> myParameters;

    // private Map<String, String> myLocalVariables;

    public UserInputCommand (VariableManager manager) {
        this("", manager);
    }

    public UserInputCommand (String commandName, VariableManager manager) {
        super(manager);
        myName = commandName;
        setNumChildren(NUM_CHILDREN);
        // myLocalVariables = new HashMap<String, String>();
        myParameters = new ArrayList<String>();
    }

    public List<String> getParameterList () {
        return myParameters;
    }

    @Override
    public double execute () {
        CommandsList myVariableList = (CommandsList)getMyChildren().get(0);
        for (int i = 0; i < myVariableList.getNumChildren(); i++) {
            myParameters.add(myVariableList.getChild(i).toString());
        }
        System.out.println("list of parameters in userinputcommand are " + myParameters);
        return 1;
    }
    
    public String getCommandName () {
        return myName;
    }

    @Override
    public String toString () {
        return myName;
    }

    @Override
    public void initializeCommand (Model model) {
    }

}
