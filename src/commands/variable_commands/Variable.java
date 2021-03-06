package commands.variable_commands;

import backEnd.Model;
import backEnd.VariableManager;
import commands.templates.Command;
import exceptions.UndefinedVariableException;


/**
 * A variable command. Contains only its value (ie. :x)
 * 
 * @author annamiyajima
 *
 */
public class Variable extends Command {

    private String myValue;

    public Variable (VariableManager manager) {
        this("", manager);
    }

    public Variable (String value, VariableManager manager) {
        super(manager);
        myValue = value.substring(1);
    }

    public String getMyValue () {
        return myValue;
    }

    @Override
    public double execute () {
        if (getVariableManager().checkVarExists(myValue)) {
            return getVariableManager().getVar(myValue);
        }
        else {
            throw new UndefinedVariableException(myValue);
        }
    }

    @Override
    public String toString () {
        return myValue;
    }

    @Override
    public void initializeCommand (Model model) {

    }

}
