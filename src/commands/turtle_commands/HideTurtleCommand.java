package commands.turtle_commands;

import backEnd.AbstractTurtle;
import backEnd.VariableManager;
import commands.templates.TurtleCommand;


public class HideTurtleCommand extends TurtleCommand {
    public static final int HIDE_TURTLE = 0;
    public static final int NUM_CHILDREN = 0;

    public HideTurtleCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
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
