package commands.variable_commands;

import commands.VariableCommand;


public class MakeCommand extends VariableCommand {

    public MakeCommand () {
        super();
        setNumChildren(1);
        // how do we specify that children should be varcommand and constant?
    }

    @Override
    public double execute () {
        return getMyChildren().get(0).execute();
    }

    @Override
    public String toString () {
        return "create var " + getMyChildren().get(0).toString() + " = " +
               getMyChildren().get(0).execute();
    }
}
