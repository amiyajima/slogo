package commands.turtle_commands;

import backEnd.VariableManager;
import backEnd.turtle.AbstractTurtle;
import commands.templates.TurtleCommand;


public class SetHeadingCommand extends TurtleCommand {

    private double myNewOrientation;
    public static final int NUM_CHILDREN = 1;

    public SetHeadingCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        AbstractTurtle myTurtle = getMyTurtle();
        double value = getMyChildren().get(0).execute() - myTurtle.getOrientation();
        System.out.println("set heading return value: " + value);
        setValue(value);
        executeTurtleCommand(getMyTurtle());
        return value;
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        myNewOrientation = getMyChildren().get(0).execute();
        t.setOrientation(myNewOrientation);
    }

    @Override
    public String toString () {
        return "New Orientation: " + getMyChildren().get(0).execute();
    }

}
