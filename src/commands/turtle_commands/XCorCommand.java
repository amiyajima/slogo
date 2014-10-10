package commands.turtle_commands;

import backEnd.AbstractTurtle;
import commands.TurtleCommand;


public class XCorCommand extends TurtleCommand {
    
    public XCorCommand() {
        setNumChildren(0);
    }

    @Override
    public double execute () {
        setValue(getMyTurtle().getX());
        System.out.println("hello");
        System.out.println(getValue());
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
