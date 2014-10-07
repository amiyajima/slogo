package commands.operation_commands;

import commands.OperationCommand;

public class SumCommand extends OperationCommand{

    @Override
    public Double execute () {
        return getMyChildren().get(0).execute() + getMyChildren().get(1).execute();
    }

}
