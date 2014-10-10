package commands.turtle_commands;

import backEnd.AbstractTurtle;

import commands.TurtleCommand;

public class ShowTurtleCommand extends TurtleCommand{
    public static final int SHOW_TURTLE = 1;
    
    public ShowTurtleCommand() {
        setNumChildren(0);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle()); 
        return SHOW_TURTLE;
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
       t.toggleVisibility(SHOW_TURTLE);
    }

    @Override
    public String toString () {
        return "Show turtle";
    }

}

