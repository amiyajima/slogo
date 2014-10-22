package commands.turtle_commands;

import backEnd.AbstractTurtle;
import commands.templates.TurtleCommand;


public class PenUpCommand extends TurtleCommand {
    public static final int PEN_UP = 0;
    public static final int NUM_CHILDREN = 0;

    public PenUpCommand () {
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
