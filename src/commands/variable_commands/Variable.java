package commands.variable_commands;

import backEnd.Model;
import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;
import commands.templates.Command;


public class Variable extends Command {

    private String myValue;

    public Variable (VariableManager manager) {
        this("", manager);
    }

    public Variable (String value, VariableManager manager) {
        super(manager);
        myValue = value.substring(1);
    }
    
    public String getMyValue(){
        return myValue;
    }

    @Override
    public double execute () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void initializeCommand (TurtleManager turtleManager) {

    }

}
