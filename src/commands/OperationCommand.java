package commands;

import java.util.List;

public abstract class OperationCommand extends Command {

    private List<Command> myChildren;

    public abstract Double execute();
    
    protected List<Command> getMyChildren() {
        return myChildren;
    }
    
}
