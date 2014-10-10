package commands.turtle_commands;

import commands.TurtleCommand;
import backEnd.AbstractTurtle;

public class IsShowingQuery extends TurtleCommand {
    public IsShowingQuery() {
        setNumChildren(0);
    }

    @Override
    public double execute () {
        setValue(getMyTurtle().isVisible()? 1.0 : 0);
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
