package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;
import commands.templates.TurtleCommand;

public class SetStrokeSize extends TurtleCommand {
    public static final int NUM_CHILDREN = 1;

    public SetStrokeSize (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        setValue(getMyChildren().get(0).execute());
        executeTurtleCommand(getMyTurtleManager());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for(Turtle turtle : turtles ) {
            turtle.getPen().setMyPenSize(getValue());
        }
    }

    @Override
    public String toString () {
        // TODO Auto-generated method stub
        return null;
    }

}
