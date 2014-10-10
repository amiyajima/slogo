package commands.turtle_commands;

import backEnd.AbstractTurtle;
import commands.TurtleCommand;


public class XCorQuery extends TurtleCommand {
    
    public XCorQuery() {
        setNumChildren(0);
    }

    @Override
    public double execute () {
        setValue(getMyTurtle().getMyX());
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
