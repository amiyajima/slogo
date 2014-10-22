package commands.variable_commands;

import backEnd.VariableManager;
import commands.templates.TwoChildCommand;


public class MakeCommand extends TwoChildCommand {

    VariableManager myVarManager;

    public MakeCommand () {
        myVarManager = new VariableManager();
    }

    @Override
    public double execute () {
        if (myVarManager.checkVarExists(getMyChildren().get(0).toString())) {
            myVarManager.addVar(getMyChildren().get(0).toString(),
                                String.valueOf(getMyChildren().get(1).execute()));
        }
        return myVarManager.getVar(getMyChildren().get(0).toString());
    }

    @Override
    public String toString () {
        return "create var " + getMyChildren().get(0).toString() + " = " +
               getMyChildren().get(1);
    }
}
