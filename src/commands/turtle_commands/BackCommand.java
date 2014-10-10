package commands.turtle_commands;

import commands.TurtleCommand;

import backEnd.AbstractTurtle;

public class BackCommand extends TurtleCommand {
    
    public BackCommand() {
        super();
        setNumChildren(1);
    }
    
    @Override
    public double execute() {
        double value = getMyChildren().get(0).execute();
        setValue(value);
        executeTurtleCommand(getMyTurtle());
        return value;
    }

    @Override
    public String toString () {
        return "Backward: " + getMyChildren().get(0).execute();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        t.moveTurtle(getValue());
    }

}
