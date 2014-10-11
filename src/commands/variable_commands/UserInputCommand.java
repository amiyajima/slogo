package commands.variable_commands;

import java.util.Map;
import backEnd.Model;
import commands.Command;
import commands.ConstantCommand;
import exceptions.SLogoException;


/**
 * A user created command
 * 
 * newcommand [ :k 5 :x 2 ] [ sum :k 5 forward :x ]
 * 
 * @author annamiyajima
 *
 */
public class UserInputCommand extends Command {

    public static final int NUM_CHILDREN = 3;
    public static String myName;
    private Map<String, Double> myVarsMap;

    public UserInputCommand (Map<String, Double> variableMap) {
        this(variableMap, "");
    }

    public UserInputCommand (Map<String, Double> variableMap, String commandName) {
        super(variableMap);
        myName = commandName;
        myVarsMap = variableMap;
    }

    @Override
    public double execute () {
        CommandsList myVariableList = (CommandsList)getMyChildren().get(1);
        System.out.println("Is this working");
        System.out.println(myVariableList);
        for (int i = 0; i < myVariableList.getNumChildren(); i++) {
            System.out.println(myVariableList.getChild(i));
            if (myVariableList.getChild(i) instanceof Variable) {
                myVarsMap.keySet().add(myVariableList.getChild(i).toString());
            }
            else if (myVariableList.getChild(i) instanceof ConstantCommand) {
                myVarsMap.put(( myVariableList.getChild(i - 1).toString()),
                              myVariableList.getChild(i).execute());
            }
            else {
                throw new SLogoException("cannot create command -- enter in correct format");
            }
        }

        getMyChildren().get(1).execute();
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
