package commands.variable_commands;

import java.io.IOException;
import backEnd.VariableManager;
import commands.templates.TwoChildCommand;


public class MakeCommand extends TwoChildCommand {

    VariableManager myVarManager;

    public MakeCommand (VariableManager manager) {
        super(manager);
        myVarManager = manager;
    }

    @Override
    public double execute () {
        System.out.println("adding var to map");
        try {
            myVarManager.addVar(getMyChildren().get(0).toString(),
                                String.valueOf(getMyChildren().get(1).execute()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return myVarManager.getVar(getMyChildren().get(0).toString());
    }

    @Override
    public String toString () {
        return "create var " + getMyChildren().get(0).toString() + " = " +
               getMyChildren().get(1);
    }
}
