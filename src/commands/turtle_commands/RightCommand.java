package commands.turtle_commands;

import backEnd.VariableManager;
import backEnd.turtle.AbstractTurtle;
import commands.templates.TurtleCommand;


public class RightCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 1;

    public RightCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        double value = getMyChildren().get(0).execute();
        setValue(value);
        executeTurtleCommand(getMyTurtle());
        return value;
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        t.turnTurtle(getValue());
    }

    @Override
    public String toString () {
        return "Right: " + getMyChildren().get(0).execute();
    }

}
