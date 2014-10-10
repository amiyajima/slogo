package commands.variable_commands;

import backEnd.Model;
import commands.Command;


public class IfCommand extends Command {
    public static final int NUM_CHILDREN = 2;

    public IfCommand () {
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        if (getMyChildren().get(0).execute() != 0) {
            return getMyChildren().get(1).execute();
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString () {
        return "If " + getMyChildren().get(0).execute() + " != 0, execute " +
               getMyChildren().get(1);
    }

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub

    }

}
