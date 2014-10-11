package commands.turtle_commands;

import java.util.Map;
import backEnd.AbstractTurtle;
import commands.TurtleCommand;


public class YCorQuery extends TurtleCommand {

    public static final int NUM_CHILDREN = 0;

    public YCorQuery (Map<String, Double> variableMap) {
        super(variableMap);
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
