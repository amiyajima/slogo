package commands.turtle_commands;

import backEnd.AbstractTurtle;
import commands.TurtleCommand;

public class HomeCommand extends TurtleCommand{
    
    public HomeCommand() {
        setNumChildren(0);
    }

    @Override
    public double execute () {
        executeTurtleCommand(getMyTurtle()); 
        return getValue();
    }

    @Override
    public void executeTurtleCommand (AbstractTurtle t) {
       setValue(t.goHome());
    }

    @Override
    public String toString () {
        return "Moved: " + getValue();
    }

}