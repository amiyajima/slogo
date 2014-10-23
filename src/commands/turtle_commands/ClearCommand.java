package commands.turtle_commands;

import backEnd.AbstractTurtle;
import backEnd.VariableManager;
import commands.templates.TurtleCommand;


public class ClearCommand extends TurtleCommand {

    public ClearCommand (VariableManager manager) {
        super(manager);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle());
        getMyTurtle().clearMyLines();
        return getValue();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        setValue(t.goHome());
    }

    @Override
    public String toString () {
        return null;
    }

}
