package commands.turtle_commands;

import backEnd.VariableManager;
import backEnd.turtle.AbstractTurtle;
import commands.templates.TurtleCommand;


public class XCorQuery extends TurtleCommand {
    public static final int NUM_CHILDREN = 0;

    public XCorQuery (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
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
