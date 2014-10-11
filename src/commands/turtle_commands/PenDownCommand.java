package commands.turtle_commands;

import java.util.Map;
import commands.Command;
import commands.TurtleCommand;
import backEnd.AbstractTurtle;


public class PenDownCommand extends TurtleCommand {
    public static final int PEN_DOWN = 1;
    public static final int NUM_CHILDREN = 0;

    public PenDownCommand (Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle());
        return PEN_DOWN;
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        t.togglePen(PEN_DOWN);
    }

    @Override
    public String toString () {
        return "Pen down";
    }

}
