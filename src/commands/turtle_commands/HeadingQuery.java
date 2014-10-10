package commands.turtle_commands;

import commands.TurtleCommand;

import backEnd.AbstractTurtle;

public class HeadingQuery extends TurtleCommand {
    
    public HeadingQuery() {
        setNumChildren(0);
    }

    @Override
    public double execute () {
        setValue(getMyTurtle().getOrientation());
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
