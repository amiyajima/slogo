package commands.turtle_commands;

import backEnd.AbstractTurtle;
import commands.templates.TurtleCommand;


public class HomeCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 0;

    public HomeCommand () {
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        setValue(t.goHome());
    }

    @Override
    public String toString () {
        return "Moved: " + getValue();
    }

}
