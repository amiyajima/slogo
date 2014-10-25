package commands.variable_commands;

import backEnd.Model;
import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;
import commands.templates.Command;
import commands.templates.OneChildCommand;


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
        System.out.println("execute variable called for " + myValue);
        if (getVariableManager().checkVarExists(myValue)) {
            System.out.println("checking if " + myValue + " exists");
            return getVariableManager().getVar(myValue);
        }
        else {
            System.out.println("throw var not found error here (in variable class)");
        }
        return 0;
    }

    @Override
    public String toString () {
        return myValue;
    }

    @Override
    public void initializeCommand (TurtleManager turtleManager) {

    }

}
