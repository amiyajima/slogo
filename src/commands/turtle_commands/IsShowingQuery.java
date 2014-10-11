package commands.turtle_commands;

import java.util.Map;
import backEnd.AbstractTurtle;
import commands.Command;
import commands.TurtleCommand;
import backEnd.AbstractTurtle;


public class IsShowingQuery extends TurtleCommand {
    public static final int NUM_CHILDREN = 0;

    public IsShowingQuery (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        setValue(getMyTurtle().isVisible() ? 1.0 : 0);
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
