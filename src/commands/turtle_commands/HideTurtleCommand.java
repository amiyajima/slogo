package commands.turtle_commands;

import backEnd.AbstractTurtle;

import commands.TurtleCommand;

public class HideTurtleCommand extends TurtleCommand{
    public static final int HIDE_TURTLE = 0;
    
    public HideTurtleCommand() {
        setNumChildren(0);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle()); 
        return HIDE_TURTLE;
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
       t.toggleVisibility(HIDE_TURTLE);
    }

    @Override
    public String toString () {
        return "Hide turtle";
    }

}