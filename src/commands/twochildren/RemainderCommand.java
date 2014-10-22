package commands.twochildren;

import commands.templates.TwoChildCommand;


public class RemainderCommand extends TwoChildCommand {

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() % getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "remainder: " + getMyChildren().get(0).execute() + " " +
               getMyChildren().get(1).execute();
    }

}
