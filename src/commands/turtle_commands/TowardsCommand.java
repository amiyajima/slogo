package commands.turtle_commands;

import backEnd.AbstractTurtle;
import backEnd.VariableManager;
import commands.templates.TurtleCommand;


public class TowardsCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 2;

    public TowardsCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        setValue(t.turnTowards(getMyChildren().get(0).execute(), getMyChildren().get(1).execute()));
    }

    @Override
    public String toString () {
        return "Turned: " + getValue();
    }

}
