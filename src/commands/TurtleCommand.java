package commands;

import java.util.List;


public abstract class TurtleCommand extends Command{
    private List<Command> myChildren;

    public abstract Double execute();
    
    protected List<Command> getMyChildren() {
        return myChildren;
    }

}
