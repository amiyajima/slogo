package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;
import commands.templates.TurtleCommand;


public class ClearCommand extends TurtleCommand {

    public ClearCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtleManager());
        return getValue();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        List<Turtle> turtles = turtleManager.getTurtleList();
        for(Turtle turtle : turtles) {
            setValue(turtle.goHome());
            turtle.clearMyLines();
        }
    }

    @Override
    public String toString () {
        return null;
    }


}
