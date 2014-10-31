// This entire file is part of my masterpiece.
// Ethan Chang

package commands.turtle_commands;

import java.util.ArrayList;
import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;
import commands.templates.TurtleCommand;
import commands.variable_commands.CommandsList;

/**
 * Command to designate which turtles will be used 
 * @author Ethan Chang
 *
 */
public class TellCommand extends TurtleCommand {
    public static final int NUM_CHILDREN = 1;

    public TellCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        CommandsList turtleCommandList = (CommandsList)getMyChildren().get(0);
        List<Double> turtleNames = new ArrayList<>();
        for (int i = 0; i < turtleCommandList.getNumChildren(); i++) {
            setValue(turtleCommandList.getChild(i).execute());
            turtleNames.add(getValue());
        }
        getMyTurtleManager().updateActiveTurtleList(turtleNames);
        return getValue();
    }



    @Override
    public String toString () {
        return null;
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {

    }

}
