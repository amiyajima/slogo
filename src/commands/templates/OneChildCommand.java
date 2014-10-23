package commands.templates;

import backEnd.Model;
import backEnd.VariableManager;

public abstract class OneChildCommand extends Command {

    public static final int NUM_CHILDREN = 1;
    
    public OneChildCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
    }
    
    @Override
    public double execute () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void initializeCommand (Model m) {
        // TODO Auto-generated method stub

    }

}
