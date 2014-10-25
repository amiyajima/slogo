package commands.turtle_commands;

import java.util.ArrayList;
import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;

import commands.templates.TurtleCommand;
import commands.variable_commands.CommandsList;

/**
 * Command to ask a certain number of turtles to do a designated number
 * of commands
 * @author ethanchang
 *
 */
public class AskCommand extends TurtleCommand {
    public static final int NUM_CHILDREN = 2;

    public AskCommand (VariableManager manager) {
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
        CommandsList turtleCommandList = (CommandsList)getMyChildren().get(0);
        List<Double> turtleNames = new ArrayList<>();
        for (int i = 0; i < turtleCommandList.getNumChildren(); i++) {
            double turtleId = turtleCommandList.getChild(i).execute();
            turtleNames.add(turtleId);
        }

        turtleManager.addTemporaryTurtleList(turtleNames);

        CommandsList commandToPerform = (CommandsList)getMyChildren().get(1);
        for (int i = 0; i < commandToPerform.getNumChildren(); i++) {
            setValue(commandToPerform.getChild(i).execute());
        }
        turtleManager.updateStoredTurtleLists();
    }

    @Override
    public String toString () {
        return null;
    }

}
