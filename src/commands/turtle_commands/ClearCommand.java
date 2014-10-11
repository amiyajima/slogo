package commands.turtle_commands;

import java.util.Map;

import backEnd.AbstractTurtle;
import commands.TurtleCommand;

public class ClearCommand extends TurtleCommand {

    public ClearCommand (Map<String, Double> variableMap) {
        super(variableMap);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle());
        getMyTurtle().clearMyLines();
        return getValue();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        setValue(t.goHome());
    }

    @Override
    public String toString () {
        return null;
    }

}
