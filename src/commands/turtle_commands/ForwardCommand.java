package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.AbstractTurtle;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;
import commands.templates.TurtleCommand;


public class ForwardCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 1;

    public ForwardCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        System.out.println("forward execute called");
        double value = getMyChildren().get(0).execute();
        setValue(value);
        executeTurtleCommand(getMyTurtleManager());
        System.out.println("forward " + value + " called");
        return value;
    }

    @Override
    public String toString () {
        return "Forward: " + getMyChildren();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for(Turtle turtle: turtles) {
            turtle.moveTurtle(-getValue());
        }
    }

}
