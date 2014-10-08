package commands.turtle_commands;

import commands.TurtleCommand;



public class ForwardCommand extends TurtleCommand {
    public ForwardCommand() {
        
        super();
        setNumChildren(1);
    }
    
    @Override
    public Double execute() {
        return getMyChildren().get(0).execute();
    }

    @Override
    public String toString () {
        return "Forward: " + getMyChildren().get(0).execute();
    }


}
