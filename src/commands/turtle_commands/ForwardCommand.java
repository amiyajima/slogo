package commands.turtle_commands;

import java.util.List;

import commands.TurtleCommand;


public class ForwardCommand extends TurtleCommand {
    
    @Override
    public Double execute() {
        return getMyChildren().get(0).execute();
    }


}
