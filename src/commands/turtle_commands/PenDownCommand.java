package commands.turtle_commands;

import commands.TurtleCommand;

import backEnd.AbstractTurtle;

public class PenDownCommand extends TurtleCommand{
    public static final int PEN_DOWN = 1;
    
    public PenDownCommand() {
        setNumChildren(0);
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
