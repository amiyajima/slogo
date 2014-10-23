package commands.turtle_commands;

import commands.templates.TurtleCommand;
import backEnd.AbstractTurtle;
import backEnd.VariableManager;


public class PenDownQuery extends TurtleCommand {
    public static final int NUM_CHILDREN = 0;

    public PenDownQuery (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        setValue(getMyTurtle().isPenDown() ? 1.0 : 0);
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
