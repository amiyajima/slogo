package commands.turtle_commands;

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


}
