package commands.twochildren;

import commands.templates.TwoChildCommand;


public class EqualCommand extends TwoChildCommand {

    @Override
    public double execute () {
        return (getMyChildren().get(0).execute() == getMyChildren().get(1).execute()) ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return "equal to result: " + execute();
    }

}
