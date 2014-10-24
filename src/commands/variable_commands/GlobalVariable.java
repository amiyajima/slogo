package commands.variable_commands;

import backEnd.VariableManager;


public class GlobalVariable extends Variable {
    private String myValue;

    public GlobalVariable (String value, VariableManager manager) {
        super(value, manager);
    }

    @Override
    public double execute () {
        System.out.println("execute variable called for " + myValue);
        if (myVariableManager.checkVarExists(myValue)) {
            return myVariableManager.getVar(myValue);
        }
        else {
            System.out.println("throw var not found error here (in variable class)");
        }
        return 0;
    }

    @Override
    public String toString () {
        return myValue;
    }
}
