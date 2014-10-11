package commands.turtle_commands;

import java.util.Map;
import backEnd.AbstractTurtle;
import commands.Command;
import commands.TurtleCommand;


public class ForwardCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 1;

    public ForwardCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        double value = getMyChildren().get(0).execute();
        setValue(value);
        executeTurtleCommand(getMyTurtle());
        System.out.println("forward execute called");
        return value;
    }

    @Override
    public String toString () {
        return "Forward: " + getMyChildren();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        t.moveTurtle(-getValue());
    }

}
