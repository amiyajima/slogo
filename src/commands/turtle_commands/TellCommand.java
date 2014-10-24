package commands.turtle_commands;

import java.util.ArrayList;
import java.util.List;

import backEnd.VariableManager;
import backEnd.turtle.TurtleManager;
import commands.templates.TurtleCommand;
import commands.variable_commands.CommandsList;

public class TellCommand extends TurtleCommand{

    public static final int NUM_CHILDREN = 1;

    public TellCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        CommandsList turtleCommandList = (CommandsList)getMyChildren().get(0);
        List<Double> turtleNames = new ArrayList<>();
        for(int i=0; i< turtleCommandList.getNumChildren(); i++) {
            setValue(turtleCommandList.getChild(i).execute());
            turtleNames.add(getValue());
        }
        getMyTurtleManager().updateActiveTurtleList(turtleNames);
        return getValue();
    }

    @Override
    public void executeTurtleCommand (TurtleManager turtleManager) {
        
    }

    @Override
    public String toString () {
        // TODO Auto-generated method stub
        return null;
    }

}
