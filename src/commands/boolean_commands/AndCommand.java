package commands.boolean_commands;

import commands.BooleanCommand;

public class AndCommand extends BooleanCommand {
    public static final int NUM_CHILDREN = 2;

    public AndCommand () {
        setNumChildren(NUM_CHILDREN);
    }

    @Override
    public double execute () {
        return (getMyChildren().get(0).execute() !=0 &&
                getMyChildren().get(1).execute()!=0) ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return "and command result: " + execute();
    }


}
