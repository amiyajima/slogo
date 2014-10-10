package commands.turtle_commands;

import commands.TurtleCommand;

import backEnd.AbstractTurtle;

public class PenDownQuery extends TurtleCommand{
    
    public PenDownQuery() {
        setNumChildren(0);
    }

    @Override
    public double execute () {
        setValue(getMyTurtle().isPenDown()? 1.0 : 0);
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
