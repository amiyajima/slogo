package commands.turtle_commands;

import backEnd.AbstractTurtle;
import backEnd.VariableManager;
import commands.templates.TurtleCommand;


public class ForwardCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 1;

    public ForwardCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        double value = getMyChildren().get(0).execute();
        setValue(value);
        executeTurtleCommand(getMyTurtle());
        System.out.println("forward " + value + " called");
        return value;
    }

    @Override
    public String toString () {
        return "Forward: " + getMyChildren();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        t.moveTurtle(-getValue());
    }

}
