package commands.turtle_commands;

import java.util.Map;
import backEnd.AbstractTurtle;
import commands.Command;
import commands.TurtleCommand;

public class PenUpCommand extends TurtleCommand{
    public static final int PEN_UP = 0;
    public static final int NUM_CHILDREN = 0;
    
    public PenUpCommand(Map<String, Double> variableMap) {
        super(variableMap);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle()); 
        return PEN_UP;
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
       t.togglePen(PEN_UP);
    }

    @Override
    public String toString () {
        return "Pen up";
    }

}
