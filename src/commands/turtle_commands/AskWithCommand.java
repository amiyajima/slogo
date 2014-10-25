package commands.turtle_commands;

import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;

import commands.templates.Command;
import commands.templates.TurtleCommand;
import commands.variable_commands.CommandsList;

public class AskWithCommand extends TurtleCommand {

    public static final int NUM_CHILDREN = 2;

    public AskWithCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {

        Command condition = getMyChildren().get(0);

        if (condition.execute() == 1) {
            executeTurtleCommand(getMyTurtleManager());
        }

        return 0;
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {

        CommandsList commandToPerform = (CommandsList)getMyChildren().get(1);
        for (int i = 0; i < commandToPerform.getNumChildren(); i++) {
            setValue(commandToPerform.getChild(i).execute());
        }
    }

    @Override
    public String toString () {
        return null;
    }

}
