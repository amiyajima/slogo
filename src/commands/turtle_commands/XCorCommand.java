package commands.turtle_commands;

import java.util.Map;
import backEnd.AbstractTurtle;
import commands.Command;
import commands.TurtleCommand;


public class XCorCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 0;

    public XCorCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        setValue(getMyTurtle().getX());
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
