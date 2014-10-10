package commands.turtle_commands;

import backEnd.AbstractTurtle;

import commands.TurtleCommand;

public class ForwardCommand extends TurtleCommand {

    public ForwardCommand() {
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
        return "Forward: " + getMyChildren().get(0).execute();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
        t.moveTurtle(-getValue());
    }


}
