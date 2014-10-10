package commands.turtle_commands;

import backEnd.AbstractTurtle;

import commands.TurtleCommand;

public class PenUpCommand extends TurtleCommand{
    public static final int PEN_UP = 0;
    
    public PenUpCommand() {
        setNumChildren(0);
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
