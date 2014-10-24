package commands.variable_commands;

import java.util.Map;
import backEnd.Model;
import backEnd.VariableManager;
import commands.ConstantCommand;
import commands.templates.Command;
import exceptions.SLogoException;


/**
 * A user created command
 * 
 * TO newcommand [ :k 5 :x 2 ] [ sum :k 5 forward :x ]
 * 
 * @author annamiyajima
 *
 */
public class UserInputCommand extends Command {

    public static final int NUM_CHILDREN = 3;
    public static String myName;
    private Map<String, Double> myVarsMap;

    public UserInputCommand (VariableManager manager) {
        this("", manager);
    }

    public UserInputCommand (String commandName, VariableManager manager) {
        super(manager);
        myName = commandName;
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        System.out.println(getMyChildren());

        CommandsList myVariableList = (CommandsList) getMyChildren().get(0);
        System.out.println(myVarsMap);
        for (int i = 0; i < myVariableList.getNumChildren(); i++) {
            System.out.println(myVariableList.getChild(i));
            Variable currentVariable = (LocalVariable) myVariableList.getChild(i);
            myVarsMap.put(currentVariable.toString(), currentVariable.execute());
        }
        getMyChildren().get(2).execute();
        return 1;
    }

    @Override
    public String toString () {
        return null;
    }

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub

    }

}
