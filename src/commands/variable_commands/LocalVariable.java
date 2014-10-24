package commands.variable_commands;

import backEnd.VariableManager;


public class LocalVariable extends Variable {

    public static final int NUM_CHILDREN = 1;

    public LocalVariable (String value, VariableManager manager) {
        super(value, manager);
        setNumChildren(NUM_CHILDREN);
    }

    public double execute () {
        return getMyChildren().get(1).execute();
    }
    
    public String toString(){
        return getMyValue();
    }

}
