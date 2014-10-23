package commands.turtle_commands;

import commands.templates.TurtleCommand;
import backEnd.VariableManager;
import backEnd.turtle.AbstractTurtle;


public class HeadingQuery extends TurtleCommand {

    public static final int NUM_CHILDREN = 0;

    public HeadingQuery (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
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
