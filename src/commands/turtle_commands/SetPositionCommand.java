package commands.turtle_commands;

import backEnd.AbstractTurtle;
import commands.templates.TurtleCommand;


public class SetPositionCommand extends TurtleCommand {
    public static final int NUM_CHILDREN = 2;

    public SetPositionCommand () {
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        setValue(t.goTo(getMyChildren().get(0).execute(), getMyChildren().get(1).execute()));
    }

    @Override
    public String toString () {
        return "Moved: " + getValue();
    }

}
