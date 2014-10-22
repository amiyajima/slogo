package commands.twochildren;

import java.util.Map;
import commands.templates.Command;
import commands.templates.TwoChildCommand;


public class QuotientCommand extends TwoChildCommand {

    @Override
    public double execute () {
        return getMyChildren().get(0).execute() / getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "dif: " + getMyChildren().get(0).execute() + " " + getMyChildren().get(1).execute();
    }

}
