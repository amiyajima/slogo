package commands.turtle_commands;

import java.util.Map;
import backEnd.AbstractTurtle;
import commands.Command;
import commands.TurtleCommand;


public class RightCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 1;

    public RightCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        double value = getMyChildren().get(0).execute();
        setValue(value);
        executeTurtleCommand(getMyTurtle());
        return value;
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        t.turnTurtle(getValue());
    }

    @Override
    public String toString () {
        return "Right: " + getMyChildren().get(0).execute();
    }

}
