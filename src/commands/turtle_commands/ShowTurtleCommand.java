package commands.turtle_commands;

import backEnd.VariableManager;
import backEnd.turtle.AbstractTurtle;
import commands.templates.TurtleCommand;


public class ShowTurtleCommand extends TurtleCommand {
    public static final int SHOW_TURTLE = 1;
    public static final int NUM_CHILDREN = 0;

    public ShowTurtleCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
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
