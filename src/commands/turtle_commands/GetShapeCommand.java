package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;
import commands.templates.TurtleCommand;

public class GetShapeCommand extends TurtleCommand {
    public static final int NUM_CHILDREN = 0;

    public GetShapeCommand (VariableManager manager) {
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
        setValue(turtles.get(turtles.size()-1).getImageIndex().getValue());
    }

    @Override
    public String toString () {
        // TODO Auto-generated method stub
        return null;
    }

}
