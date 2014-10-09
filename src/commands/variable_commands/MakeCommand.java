package commands.variable_commands;

import commands.VariableCommand;

public class MakeCommand extends VariableCommand {
    
    public MakeCommand () {
        super();
        setNumChildren(2);
        //how do we specify that children should be varcommand and constant?
    }

    @Override
    public Double execute () {
        return getMyChildren().get(0).execute() + getMyChildren().get(1).execute();
    }

    @Override
    public String toString () {
        return "create var" + getMyChildren().get(0).toString() + " = " + getMyChildren().get(1).execute();
    }
}
