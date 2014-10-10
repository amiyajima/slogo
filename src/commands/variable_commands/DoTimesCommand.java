package commands.variable_commands;

import backEnd.Model;
import commands.Command;


public class DoTimesCommand extends Command {

    public static final int NUM_CHILDREN = 2;

    public DoTimesCommand () {
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        Double result = 0.0;
        for (int i = 0; i < getMyChildren().get(0).execute(); i++) {
            getMyChildren().get(1).execute();
        }
        return result;
    }

    @Override
    public String toString () {
        return "do " + getMyChildren().get(1).toString() + " " +
               getMyChildren().get(0).execute() + " times.";
    }

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub

    }

    // dotimes [ :k constant ] [list of commands]
}
