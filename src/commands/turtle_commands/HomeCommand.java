package commands.turtle_commands;

import java.util.Map;
import backEnd.AbstractTurtle;
import commands.Command;
import commands.TurtleCommand;


public class HomeCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 0;

    public HomeCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        setValue(t.goHome());
    }

    @Override
    public String toString () {
        return "Moved: " + getValue();
    }

}
