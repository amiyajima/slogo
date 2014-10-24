package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.AbstractTurtle;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;
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
        executeTurtleCommand(getMyTurtleManager());
        return value;
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for(Turtle t : turtles) {
            t.turnTurtle(getValue());
        }
    }

    @Override
    public String toString () {
        return "Right: " + getMyChildren().get(0).execute();
    }

}
