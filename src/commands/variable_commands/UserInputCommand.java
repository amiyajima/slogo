package commands.variable_commands;

import java.util.ArrayList;
import java.util.List;

import backEnd.Model;
import backEnd.VariableManager;

import commands.templates.Command;


/**
 * A user created command
 *
 * TO newcommand [ :k :x ] [ sum :k 5 forward :x ]
 *
 * @author annamiyajima
 *
 */
public class UserInputCommand extends Command {

    public static final int NUM_CHILDREN = 2;
    public String myName;
    private List <String> myParameters;
    //private Map<String, String> myLocalVariables;

    public UserInputCommand (VariableManager manager) {
        this("", manager);
    }

    public UserInputCommand (String commandName, VariableManager manager) {
        super(manager);
        myName = commandName;
        setNumChildren(NUM_CHILDREN);
        //myLocalVariables = new HashMap<String, String>();
        myParameters = new ArrayList<String>();
    }
    
    public List<String> getParameterList(){
     return myParameters;   
    }

    @Override
    public double execute () {
        /*VariableManager variablemanager = getVariableManager();
        CommandsList myVariableList = (CommandsList) getMyChildren().get(0);
        // works up to here then UnsupportedOperationException
        for (int i = 0; i < myVariableList.getNumChildren(); i++) {
            if (myVariableList.getChild(i) instanceof Variable) {
                // just skip over variable names
            }
            else if (myVariableList.getChild(i) instanceof ConstantCommand) {
                myLocalVariables.put((myVariableList.getChild(i - 1).toString()),
                                     myVariableList.getChild(i).toString());
            }
            else {
                throw new SLogoException("cannot create command -- enter in correct format");
            }
        }
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
        }*/
        CommandsList myVariableList = (CommandsList) getMyChildren().get(0);
        for(int i = 0; i<myVariableList.getNumChildren();i++){
            myParameters.add(myVariableList.getChild(i).toString());
        }
        System.out.println("list of parameters in userinputcommand are " + myParameters);
        return 1;
    }

    @Override
    public String toString () {
        return myName;
    }

    @Override
    public void initializeCommand (Model model) {
        // TODO Auto-generated method stub

    }

}
