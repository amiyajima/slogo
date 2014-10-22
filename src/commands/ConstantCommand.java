package commands;

import java.util.Map;
import commands.templates.Command;
import backEnd.Model;

/**
 * A constant command is created when just a double is entered as a parameter
 * Thus there is an additional constructor, which adds in a string value which
 * represents the double to be used. Executing the command simply results in
 * the returning of the double saved.
 * 
 * @author Ethan Chang
 * @author Anna Miyajima
 *
 */
public class ConstantCommand extends Command {

    private String myValue;

    public ConstantCommand () {
        this("");
    }

    /**
     * ConstantCommands take in the additional variable of a String
     * @param myVariableMap map of all variables
     * @param value the constant used to create the command.
     */
    public ConstantCommand (String value) {
        super();
        myValue = value;
    }
    
    /**
     * Returns the set constant
     */
    @Override
    public double execute () {
        return Double.parseDouble(myValue);
    }

    @Override
    public String toString () {
        return myValue;
    }

    @Override
    public void initializeCommand (Model m) {
    }

}
