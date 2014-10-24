package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;
import commands.templates.TurtleCommand;

public class IdCommand extends TurtleCommand{
    public static final int NUM_CHILDREN = 0;


    public IdCommand (VariableManager manager) {
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
        List<Turtle> turtleList = turtleManager.getTurtleList();
        setValue(Double.parseDouble(turtleList.get(turtleList.size()-1).getId()));
    }

    @Override
    public String toString () {
        return Double.toString(getValue());
    }

}
