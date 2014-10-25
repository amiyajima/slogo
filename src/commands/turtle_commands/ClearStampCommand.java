package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;
import commands.templates.TurtleCommand;

public class ClearStampCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 0;
    
    public ClearStampCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        return 0;
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for(Turtle turtle : turtles) {
            turtle.clearStamp();
        }
    }

    @Override
    public String toString () {
        return null;
    }

}
