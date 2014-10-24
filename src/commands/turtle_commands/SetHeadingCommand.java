package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.AbstractTurtle;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;
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

        executeTurtleCommand(getMyTurtleManager());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        myNewOrientation = getMyChildren().get(0).execute();
        
        turtleManager = getMyTurtleManager();
        List<Turtle> turtles = turtleManager.getTurtleList();
        for(Turtle t : turtles) {
            t.setOrientation(myNewOrientation);
            setValue(myNewOrientation - t.getOrientation());
        }
    }

    @Override
    public String toString () {
        return "New Orientation: " + getMyChildren().get(0).execute();
    }

}
