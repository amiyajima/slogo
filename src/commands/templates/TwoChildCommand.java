package commands.templates;

import backEnd.Model;
import backEnd.VariableManager;


public abstract class TwoChildCommand extends Command {

    public static final int NUM_CHILDREN = 2;

    public TwoChildCommand (VariableManager manager) {
        super(manager);
        setNumChildren(NUM_CHILDREN);
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
