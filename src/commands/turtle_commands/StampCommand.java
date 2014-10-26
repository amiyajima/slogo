package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

public class StampCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 0;

    public StampCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for (Turtle turtle : turtles) {
            turtle.setStamp();
            setValue(turtle.getShapeIndex().getValue());
        }

    }

    @Override
    public String toString () {
        return null;
    }

}
