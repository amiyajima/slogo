package commands.turtle_commands;

import backEnd.AbstractTurtle;
import commands.TurtleCommand;

public class LeftCommand extends TurtleCommand {

    public LeftCommand() {
        super();
        setNumChildren(1);
    }

    @Override
    public Double execute () {
        double value = getMyChildren().get(0).execute();
        setValue(value);
        executeTurtleCommand(getMyTurtle()); 
        return value;
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
       t.turnTurtle(getValue());
    }

    @Override
    public String toString () {
        return null;
    }

}
