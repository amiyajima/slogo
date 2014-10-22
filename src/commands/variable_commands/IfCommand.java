package commands.variable_commands;

import backEnd.Model;
import commands.templates.TwoChildCommand;


public class IfCommand extends TwoChildCommand {

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
