package commands.turtle_commands;

import backEnd.Turtle;
import commands.TurtleCommand;



public class ForwardCommand extends TurtleCommand {
        
    @Override
    public Double execute() {
        double value = getMyChildren().get(0).execute();
        executeTurtleCommand(getMyTurtle());
        return value;
    }

    @Override
    public String toString () {
        return "Forward: " + getMyChildren().get(0).execute();
    }

    @Override
    public void executeTurtleCommand (Turtle t) {
        
    }


}
