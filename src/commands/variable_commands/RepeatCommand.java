package commands.variable_commands;

import backEnd.Model;
import backEnd.VariableManager;

import commands.templates.TwoChildCommand;

public class RepeatCommand extends TwoChildCommand {

    public RepeatCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        Double result = 0.0;
        for (int i = 0; i < getMyChildren().get(0).execute(); i++) {
            result += getMyChildren().get(1).execute();
        }
        return result;
    }

    @Override
    public String toString () {
        return "repeat " + getMyChildren().get(1).toString() + " "
                + getMyChildren().get(0).execute() + " times.";
    }

    @Override
    public void initializeCommand (Model model) {

    }

}
