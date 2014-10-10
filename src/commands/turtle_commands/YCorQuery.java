package commands.turtle_commands;

import backEnd.AbstractTurtle;

import commands.TurtleCommand;

public class YCorQuery extends TurtleCommand {
    
    public YCorQuery() {
        setNumChildren(0);
    }

    @Override
    public double execute () {
        setValue(getMyTurtle().getMyY());
        return getValue();
    }

    @Override
    public String toString () {
        return Double.toString(getValue());
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {        
    }
    
}
