package commands.turtle_commands;

import backEnd.Turtle;
import commands.TurtleCommand;



public class ForwardCommand extends TurtleCommand {
    public ForwardCommand() {
        
        super();
        setNumChildren(1);
    }
    
    @Override
    public Double execute() {
        double value = getMyChildren().get(0).execute();
        executeTurtleCommand();
        return value
    }

    @Override
    public String toString () {
        return "Forward: " + getMyChildren().get(0).execute();
    }

    @Override
    public void executeTurtleCommand (Turtle t) {
        // TODO Auto-generated method stub
        
    }


}
