package commands.boolean_commands;

import commands.BooleanCommand;

public class LessThanCommand extends BooleanCommand {
    
    public LessThanCommand() {
        super();
        setNumChildren(2);
    }
    
    @Override
    public Double execute () {
        return (getMyChildren().get(0).execute() < getMyChildren().get(1).execute()) ? 1.0 : 0.0;
    }

    @Override
    public String toString () {
        return null;
    }

}
