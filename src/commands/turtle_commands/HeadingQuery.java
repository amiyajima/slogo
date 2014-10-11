package commands.turtle_commands;

import java.util.Map;
import commands.TurtleCommand;
import backEnd.AbstractTurtle;


public class HeadingQuery extends TurtleCommand {

    public static final int NUM_CHILDREN = 0;

    public HeadingQuery (Map<String, Double> variableMap) {
        super(variableMap);
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
