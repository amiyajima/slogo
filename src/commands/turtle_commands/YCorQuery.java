package commands.turtle_commands;

import backEnd.AbstractTurtle;
import commands.templates.TurtleCommand;


public class YCorQuery extends TurtleCommand {

    public static final int NUM_CHILDREN = 0;

    public YCorQuery () {
        setNumChildren(NUM_CHILDREN);
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
