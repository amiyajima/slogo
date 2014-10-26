package commands.turtle_commands;

import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.Turtle;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;

/**
 * Returns whether the turtle is showing or not
 * @author ethanchang
 *
 */
public class IsShowingQuery extends TurtleCommand {
    public static final int NUM_CHILDREN = 0;

    public IsShowingQuery (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        List<Turtle> turtles = getMyTurtleManager().getTurtleList();

        setValue(turtles.get(turtles.size() - 1).isVisible() ? 1.0 : 0);
        System.out.println(getValue());
        return getValue();
    }

    @Override
    public String toString () {
        return Double.toString(getValue());
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
    }

}
